package io.github.sploit.projects.taskmanager.common.services;

import java.util.List;

import io.github.sploit.projects.taskmanager.common.dtos.BaseDto;

public interface BService<T extends BaseDto, ID> {
    List<T> getAll();
    T getById(ID id);
    T add(T dto);
    T update(ID id, T dto);
    Boolean deleteById(ID id);
}
