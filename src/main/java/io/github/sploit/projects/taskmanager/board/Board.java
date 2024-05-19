package io.github.sploit.projects.taskmanager.board;

import java.util.ArrayList;

import io.github.sploit.projects.taskmanager.common.entities.TitledEntity;
import io.github.sploit.projects.taskmanager.list.List;
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
@Table(name = "boards")
public class Board extends TitledEntity {
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "board_id")
    private java.util.List<List> lists = new ArrayList<>();
}
