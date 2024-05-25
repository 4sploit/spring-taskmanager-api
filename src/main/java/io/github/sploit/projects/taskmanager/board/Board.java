package io.github.sploit.projects.taskmanager.board;

import java.util.HashSet;
import java.util.Set;

import io.github.sploit.projects.taskmanager.common.entities.TitledEntity;
import io.github.sploit.projects.taskmanager.list.List;
import jakarta.persistence.CascadeType;
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
@Table(name = "boards", indexes = @Index(name="idx_board_title", columnList = "title"))
public class Board extends TitledEntity {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "board_id")
    private Set<List> lists = new HashSet<>();
}
