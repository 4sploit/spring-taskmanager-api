package io.github.sploit.projects.taskmanager.task;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<TaskDto>> getAll() {
        List<TaskDto> tasks = taskService.getAll();
        return ResponseEntity.ok(tasks);
    }

    @Override
    public ResponseEntity<TaskDto> getById(Long id) {
        return taskService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<TaskDto> add(TaskDto req) {
        TaskDto newTask = taskService.add(req);
        return ResponseEntity.ok(newTask);
    }

    @Override
    public ResponseEntity<TaskDto> update(Long id, TaskDto req) {
        TaskDto updatedTask = taskService.update(id, req);
        return ResponseEntity.ok(updatedTask);
    }

    @Override
    public ResponseEntity<Boolean> deleteById(Long id) {
        boolean isDeleted = taskService.deleteById(id);
        return ResponseEntity.ok(isDeleted);
    }

    @Override
    public ResponseEntity<List<TaskDto>> getByListId(Long listId) {
        List<TaskDto> tasksOfList = taskService.getByListId(listId);
        return ResponseEntity.ok(tasksOfList);
    }
}
