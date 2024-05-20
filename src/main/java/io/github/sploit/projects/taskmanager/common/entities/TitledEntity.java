package io.github.sploit.projects.taskmanager.common.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class TitledEntity extends BaseEntity {
    @NotBlank
    @Column(name = "title")
    private String title;
}
