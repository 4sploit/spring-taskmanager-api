package io.github.sploit.projects.taskmanager.task;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task")
public class TaskController implements TaskApiController {
    private final TaskService taskService;

    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @Override
    public List<TaskDto> getAll() {
        return taskService.getAll();
    }

    @Override
    public TaskDto getById(Long id) {
        return taskService.getById(id);
    }

    @Override
    public TaskDto add(TaskDto req) {
        return taskService.add(req);
    }

    @Override
    public TaskDto update(Long id, TaskDto req) {
        return taskService.update(id, req);
    }

    @Override
    public Boolean deleteById(Long id) {
        return taskService.deleteById(id);
    }
}
