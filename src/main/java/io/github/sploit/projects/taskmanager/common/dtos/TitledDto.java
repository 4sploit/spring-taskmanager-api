package io.github.sploit.projects.taskmanager.common.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TitledDto extends BaseDto {
    @JsonProperty("title")
    private String title;
}
