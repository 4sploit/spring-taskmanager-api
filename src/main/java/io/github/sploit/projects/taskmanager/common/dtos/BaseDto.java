package io.github.sploit.projects.taskmanager.common.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty(value = "created_at", access = JsonProperty.Access.READ_ONLY)
    private LocalDate createdAt;

    @JsonProperty(value = "updated_at", access = JsonProperty.Access.READ_ONLY)
    private LocalDate updatedAt = LocalDate.now();
}
