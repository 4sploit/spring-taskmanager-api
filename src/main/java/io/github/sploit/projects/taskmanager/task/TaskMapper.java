package io.github.sploit.projects.taskmanager.task;

import org.mapstruct.Mapper;

import io.github.sploit.projects.taskmanager.common.configurations.MapStructConfig;
import io.github.sploit.projects.taskmanager.common.mappers.BaseMapper;

@Mapper(config = MapStructConfig.class)
public interface TaskMapper extends BaseMapper<Task, TaskDto> {
}
