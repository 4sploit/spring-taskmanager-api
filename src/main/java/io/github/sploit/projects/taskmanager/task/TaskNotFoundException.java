package io.github.sploit.projects.taskmanager.task;

import io.github.sploit.projects.taskmanager.common.exceptions.ItemNotFoundException;

public class TaskNotFoundException extends ItemNotFoundException {
    public TaskNotFoundException(Long id) {
        super(id);
    }
}
