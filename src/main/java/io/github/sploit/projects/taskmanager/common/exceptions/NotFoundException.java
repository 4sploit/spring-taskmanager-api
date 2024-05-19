package io.github.sploit.projects.taskmanager.common.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super(
            String.format("%d Not Found", id.toString())
        );
    }
}
