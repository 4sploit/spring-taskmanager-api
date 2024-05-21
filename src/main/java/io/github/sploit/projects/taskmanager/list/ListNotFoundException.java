package io.github.sploit.projects.taskmanager.list;

import io.github.sploit.projects.taskmanager.common.exceptions.ItemNotFoundException;

public class ListNotFoundException extends ItemNotFoundException {
    public ListNotFoundException(Long id) {
        super(id);
    }
}
