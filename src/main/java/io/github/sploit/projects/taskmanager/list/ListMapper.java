package io.github.sploit.projects.taskmanager.list;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

import io.github.sploit.projects.taskmanager.task.TaskMapper;


@Mapper(uses=TaskMapper.class, componentModel = ComponentModel.SPRING)
public interface ListMapper {
    @Mapping(source="createDate", target = "createdAt")
    @Mapping(source="updateDate", target = "updatedAt")
    ListDto toListDto(List newList);
    List toList(ListDto board);
}
