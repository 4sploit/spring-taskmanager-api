package io.github.sploit.projects.taskmanager.common.errors;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.sploit.projects.taskmanager.common.constants.ErrorTitles;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationError {
    @JsonProperty
    private final String title = ErrorTitles.VALIDATION_ERROR_TITLE;
    @JsonProperty("error_details")
    private Set<ErrorDetails> errorDetails;
}
