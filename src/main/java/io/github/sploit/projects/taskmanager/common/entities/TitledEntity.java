package io.github.sploit.projects.taskmanager.common.entities;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class TitledEntity extends BaseEntity {
    @NonNull
    @Column(name = "title")
    private String title;
}
