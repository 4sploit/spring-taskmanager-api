package io.github.sploit.projects.taskmanager.common.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public class ErrorDetails {
    @JsonProperty("field_name")
    private String fieldName;
    @JsonProperty
    private String message;
}
