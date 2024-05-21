package io.github.sploit.projects.taskmanager.task;

import java.util.List;

import io.github.sploit.projects.taskmanager.common.services.BService;

public interface TaskService extends BService<TaskDto, Long> {
    List<TaskDto> getByListId(Long listId);
}
