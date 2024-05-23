package io.github.sploit.projects.taskmanager.common.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.sploit.projects.taskmanager.common.constants.FieldValidationErrorMessages;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TitledDto extends BaseDto {
    @NotBlank(message = FieldValidationErrorMessages.NOT_BLANK)
    @JsonProperty
    private String title;
}
