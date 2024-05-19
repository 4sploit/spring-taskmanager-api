package io.github.sploit.projects.taskmanager.board;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.sploit.projects.taskmanager.list.ListDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("lists")
    private Set<ListDto> lists;

    @JsonProperty("createdAt")
    private LocalDate createdAt;

    @JsonProperty("updatedAt")
    private LocalDate updatedAt;
}
