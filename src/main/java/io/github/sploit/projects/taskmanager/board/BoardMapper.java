package io.github.sploit.projects.taskmanager.board;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import io.github.sploit.projects.taskmanager.common.mappers.BaseMapper;
import io.github.sploit.projects.taskmanager.list.ListMapper;

@Mapper(uses = ListMapper.class, componentModel = ComponentModel.SPRING)
public interface BoardMapper extends BaseMapper<Board, BoardDto> {
}
