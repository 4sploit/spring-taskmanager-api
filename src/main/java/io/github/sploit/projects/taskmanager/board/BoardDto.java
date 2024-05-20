package io.github.sploit.projects.taskmanager.board;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.sploit.projects.taskmanager.common.dtos.TitledDto;
import io.github.sploit.projects.taskmanager.list.ListDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto extends TitledDto {
    @JsonProperty("lists")
    private Set<ListDto> lists;
}
