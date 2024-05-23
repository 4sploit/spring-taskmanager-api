package io.github.sploit.projects.taskmanager.common.errors;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

@Builder
public class ApiError {
    @JsonProperty
    private String key;

    @JsonProperty
    private String message;

    @JsonProperty("error_details")
    private Set<ErrorDetails> errorDetails;
}
