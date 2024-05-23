package io.github.sploit.projects.taskmanager.list;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.sploit.projects.taskmanager.common.constants.FieldValidationErrorMessages;
import io.github.sploit.projects.taskmanager.common.dtos.TitledDto;
import io.github.sploit.projects.taskmanager.task.TaskDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListDto  extends TitledDto {
    @JsonProperty(value = "tasks", access = JsonProperty.Access.READ_ONLY)
    private Set<TaskDto> tasks;
    @NotNull(message = FieldValidationErrorMessages.NOT_NULL)
    @JsonProperty(value = "boardId")
    private Long boardId;
}
