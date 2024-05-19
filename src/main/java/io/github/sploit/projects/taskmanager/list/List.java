package io.github.sploit.projects.taskmanager.list;

import java.util.ArrayList;

import io.github.sploit.projects.taskmanager.common.entities.TitledEntity;
import io.github.sploit.projects.taskmanager.task.Task;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "lists")
public class List extends TitledEntity {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "list_id")
    private java.util.List<Task> tasks = new ArrayList<>();
}
