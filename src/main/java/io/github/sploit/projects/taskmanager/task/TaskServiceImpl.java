package io.github.sploit.projects.taskmanager.task;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.github.sploit.projects.taskmanager.common.exceptions.ItemNotFoundException;

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
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @Override
    public TaskDto add(TaskDto dto) {
        Task newTask = taskRepository.save(
                taskMapper.dtoToEntity(dto));

        return taskMapper.entityToDto(newTask);
    }

    @Override
    public TaskDto update(Long id, TaskDto dto) {
        return taskRepository.findById(id)
                .map(task -> {
                    taskMapper.updateEntityFromDto(dto, task);
                    Task updatedTask = taskRepository.save(task);
                    return taskMapper.entityToDto(updatedTask);
                })
                .orElseGet(() -> {
                    Task taskToAdd = new Task();
                    taskMapper.updateEntityFromDto(dto, taskToAdd);
                    Task newTask = taskRepository.save(taskToAdd);
                    return taskMapper.entityToDto(newTask);
                });
    }

    @Override
    public Boolean deleteById(Long id) {
        taskRepository.deleteById(id);
        return taskRepository.existsById(id);
    }

    @Override
    public List<TaskDto> getByListId(Long listId) {
        return taskRepository.findByListId(listId)
                .stream()
                .map(taskMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
