package io.github.sploit.projects.taskmanager.common.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long id) {
        super(
            String.format("%d Not Found", id.toString())
        );
    }
}
