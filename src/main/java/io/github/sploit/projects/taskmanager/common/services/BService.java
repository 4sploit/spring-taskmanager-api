package io.github.sploit.projects.taskmanager.common.services;

import java.util.List;

public interface BService<TDto, ID> {
    List<TDto> getAll();
    TDto getById(ID id);
    TDto add(TDto dto);
    TDto update(ID id, TDto dto);
    Boolean deleteById(ID id);
}
