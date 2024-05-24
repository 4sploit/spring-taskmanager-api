package io.github.sploit.projects.taskmanager.task;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "tasks")
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
    @Cacheable
    public List<TaskDto> getAll() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Cacheable(key = "#id")
    public Optional<TaskDto> getById(Long id) {
        return taskRepository.findById(id)
                .stream()
                .map(taskMapper::entityToDto)
                .findFirst();
    }

    @Override
    @CacheEvict(key = "#newTask.id")
    public TaskDto add(TaskDto dto) {
        Task newTask = taskRepository.save(
                taskMapper.dtoToEntity(dto));

        return taskMapper.entityToDto(newTask);
    }

    @Override
    @CacheEvict(key = "#id")
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
    @CacheEvict(key = "#id")
    public Boolean deleteById(Long id) {
        taskRepository.deleteById(id);
        return taskRepository.existsById(id);
    }

    @Override
    @Cacheable(key = "#listId")
    public List<TaskDto> getByListId(Long listId) {
        return taskRepository.findByListId(listId)
                .stream()
                .map(taskMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
