package io.github.sploit.projects.taskmanager.common.exceptions;

import io.github.sploit.projects.taskmanager.common.constants.ExceptionMessages;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(Long id) {
        super(
            String.format(ExceptionMessages.ITEM_NOT_found, id)
        );
    }
}
