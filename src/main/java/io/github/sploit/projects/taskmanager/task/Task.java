package io.github.sploit.projects.taskmanager.task;

import io.github.sploit.projects.taskmanager.common.entities.TitledEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tasks", indexes = @Index(name = "idx_list_id", columnList = "list_id"))
public class Task extends TitledEntity {
    @Column(name = "description")
    private String description;
    @Column(name = "list_id")
    private Long listId;
}
