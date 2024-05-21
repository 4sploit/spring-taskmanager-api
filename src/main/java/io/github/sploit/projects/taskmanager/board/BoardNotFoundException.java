package io.github.sploit.projects.taskmanager.board;

import io.github.sploit.projects.taskmanager.common.exceptions.ItemNotFoundException;

public class BoardNotFoundException extends ItemNotFoundException {
    public BoardNotFoundException(Long id) {
        super(id);
    }
}
