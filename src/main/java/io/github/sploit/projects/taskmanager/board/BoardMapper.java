package io.github.sploit.projects.taskmanager.board;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import io.github.sploit.projects.taskmanager.list.ListMapper;

@Mapper(uses=ListMapper.class, componentModel = ComponentModel.SPRING)
public interface BoardMapper {
    @Mapping(source="createDate", target = "createdAt")
    @Mapping(source="updateDate", target = "updatedAt")
    BoardDto toBoardDto(Board board);
    Board toBoard(BoardDto board);
}
