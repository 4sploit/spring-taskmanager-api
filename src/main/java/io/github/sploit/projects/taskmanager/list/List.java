package io.github.sploit.projects.taskmanager.list;

import java.util.HashSet;
import java.util.Set;

import io.github.sploit.projects.taskmanager.common.entities.TitledEntity;
import io.github.sploit.projects.taskmanager.task.Task;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Index;
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
@Table(name = "lists", indexes = @Index(name = "idx_board_id", columnList = "board_id"))
public class List extends TitledEntity {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "list_id")
    private Set<Task> tasks = new HashSet<>();
    @Column(name = "board_id")
    private Long boardId;
}
