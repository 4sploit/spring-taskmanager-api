package io.github.sploit.projects.taskmanager.task;

import io.github.sploit.projects.taskmanager.common.entities.TitledEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tasks")
public class Task extends TitledEntity {
    @Column(name = "description")
    private String description;
}
