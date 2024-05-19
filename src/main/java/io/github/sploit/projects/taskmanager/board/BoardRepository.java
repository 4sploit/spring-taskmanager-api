package io.github.sploit.projects.taskmanager.board;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
public interface BoardRepository extends JpaRepository<Board, Long> {
}
