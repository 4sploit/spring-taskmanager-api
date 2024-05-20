package io.github.sploit.projects.taskmanager.board;

import org.mapstruct.Mapper;

import io.github.sploit.projects.taskmanager.common.configurations.MapConfig;
import io.github.sploit.projects.taskmanager.common.mappers.BaseMapper;
import io.github.sploit.projects.taskmanager.list.ListMapper;

@Mapper(config = MapConfig.class, uses = ListMapper.class)
public interface BoardMapper extends BaseMapper<Board, BoardDto> {
}
