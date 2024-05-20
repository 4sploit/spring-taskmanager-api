package io.github.sploit.projects.taskmanager.list;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.sploit.projects.taskmanager.common.dtos.TitledDto;
import io.github.sploit.projects.taskmanager.task.TaskDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListDto  extends TitledDto {
    @JsonProperty("tasks")
    private Set<TaskDto> tasks;
}
