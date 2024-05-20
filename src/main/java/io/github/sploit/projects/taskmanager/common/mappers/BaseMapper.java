package io.github.sploit.projects.taskmanager.common.mappers;

import org.mapstruct.Mapping;

import io.github.sploit.projects.taskmanager.common.dtos.BaseDto;
import io.github.sploit.projects.taskmanager.common.entities.BaseEntity;

public interface BaseMapper<T extends BaseEntity, D extends BaseDto> {
    @Mapping(source = "createDate", target = "createdAt")
    @Mapping(source = "updateDate", target = "updatedAt")
    D entityToDto(T entity);

    T dtoToEntity(D dto);
}
