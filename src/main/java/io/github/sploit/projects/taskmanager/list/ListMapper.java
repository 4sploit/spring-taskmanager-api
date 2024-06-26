package io.github.sploit.projects.taskmanager.list;

import org.mapstruct.Mapper;

import io.github.sploit.projects.taskmanager.common.configurations.MapStructConfig;
import io.github.sploit.projects.taskmanager.common.mappers.BaseMapper;
import io.github.sploit.projects.taskmanager.task.TaskMapper;

@Mapper(config = MapStructConfig.class, uses = TaskMapper.class)
public interface ListMapper extends BaseMapper<List, ListDto> {
}
