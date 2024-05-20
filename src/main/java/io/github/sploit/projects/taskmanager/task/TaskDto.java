package io.github.sploit.projects.taskmanager.task;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.sploit.projects.taskmanager.common.dtos.TitledDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto extends TitledDto {
    @JsonProperty("description")
    private String description;
}
