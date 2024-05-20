package io.github.sploit.projects.taskmanager.task;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import io.github.sploit.projects.taskmanager.common.mappers.BaseMapper;

@Mapper(componentModel = ComponentModel.SPRING)
public interface TaskMapper extends BaseMapper<Task, TaskDto> {
}
