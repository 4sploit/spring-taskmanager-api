package io.github.sploit.projects.taskmanager.task;

import java.util.UUID;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(UUID id) {
        super(
            String.format("Task (%s) not found", id.toString())
        );
    }
}
