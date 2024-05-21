package io.github.sploit.projects.taskmanager.common.advices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.github.sploit.projects.taskmanager.common.exceptions.ItemNotFoundException;

@RestControllerAdvice
public class ItemNotFoundAdvice {
    @ExceptionHandler(ItemNotFoundException.class)
	ResponseEntity<Object> itemNotFoundAdviceHandler(ItemNotFoundException ex) {
        return ResponseEntity.notFound().build();
	}
}
w