package io.github.sploit.projects.taskmanager.list;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import io.github.sploit.projects.taskmanager.common.mappers.BaseMapper;
import io.github.sploit.projects.taskmanager.task.TaskMapper;

@Mapper(uses = TaskMapper.class, componentModel = ComponentModel.SPRING)
public interface ListMapper extends BaseMapper<List, ListDto> {
}
