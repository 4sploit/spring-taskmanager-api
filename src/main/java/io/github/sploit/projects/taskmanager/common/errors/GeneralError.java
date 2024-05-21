package io.github.sploit.projects.taskmanager.common.errors;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.sploit.projects.taskmanager.common.constants.ErrorMessages;
import io.github.sploit.projects.taskmanager.common.constants.ErrorTitles;
import lombok.Builder;

@Builder
public class GeneralError {
    @JsonProperty
    private final String title = ErrorTitles.GENERAL;
    @JsonProperty
    private final String message = ErrorMessages.GENERAL_ERROR;
}
