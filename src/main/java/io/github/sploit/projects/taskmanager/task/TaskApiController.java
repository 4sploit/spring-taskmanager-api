package io.github.sploit.projects.taskmanager.task;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import io.github.sploit.projects.taskmanager.common.controllers.ApiController;

public interface TaskApiController extends ApiController<TaskDto, TaskDto, Long> {
    @GetMapping("/getByListId/listId")
    ResponseEntity<List<TaskDto>> getByListId(Long listId);
}
