package io.github.sploit.projects.taskmanager.task;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.v3.oas.annotations.Hidden;

@Hidden
public interface TaskRepository extends JpaRepository<Task, Long> {
}
