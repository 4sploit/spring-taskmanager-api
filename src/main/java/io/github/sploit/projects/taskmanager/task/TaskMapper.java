package io.github.sploit.projects.taskmanager.task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;


@Mapper(componentModel = ComponentModel.SPRING)
public interface TaskMapper {
    @Mapping(source="createDate", target = "createdAt")
    @Mapping(source="updateDate", target = "updatedAt")
    TaskDto toTaskDto(Task board);
    Task toTask(TaskDto board);
}
