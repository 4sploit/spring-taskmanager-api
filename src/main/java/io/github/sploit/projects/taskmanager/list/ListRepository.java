package io.github.sploit.projects.taskmanager.list;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
public interface ListRepository extends JpaRepository<List, Long> {
}
