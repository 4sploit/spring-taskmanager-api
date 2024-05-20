package io.github.sploit.projects.taskmanager.task;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.github.sploit.projects.taskmanager.common.exceptions.NotFoundException;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    TaskServiceImpl(
        TaskRepository taskRepository,
        TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public List<TaskDto> getAll() {
        return taskRepository.findAll()
                    .stream()
                    .map(task -> taskMapper.entityToDto(task))
                     .collect(Collectors.toList());
    }

    @Override
    public TaskDto getById(Long id) {
        return taskRepository.findById(id)
                    .stream()
                    .map(task -> taskMapper.entityToDto(task))
                    .findFirst()
                    .orElseThrow(() -> new NotFoundException(id));
    }

    @Override
    public TaskDto add(TaskDto dto) {
        Task newTask = taskRepository.save(
            taskMapper.dtoToEntity(dto)
        );

        return taskMapper.entityToDto(newTask);
    }

    @Override
    public TaskDto update(Long id, TaskDto dto) {
        return taskRepository.findById(id)
                    .map(task -> {
                        task.setTitle(dto.getTitle());
                        Task updatedTask = taskRepository.save(task);
                        return taskMapper.entityToDto(updatedTask);
                    })
                    .orElseGet(() -> {
                        Task taskToAdd = new Task();
                        taskToAdd.setTitle(dto.getTitle());
                        taskToAdd.setDescription(dto.getDescription());
                        Task newTask = taskRepository.save(taskToAdd);
                        return taskMapper.entityToDto(newTask);
                    });
    }

    @Override
    public Boolean deleteById(Long id) {
        taskRepository.deleteById(id);
        return taskRepository.existsById(id);
    }
}
