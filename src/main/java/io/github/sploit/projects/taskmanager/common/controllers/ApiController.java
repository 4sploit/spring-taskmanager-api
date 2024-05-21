package io.github.sploit.projects.taskmanager.common.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.github.sploit.projects.taskmanager.common.dtos.BaseDto;
import jakarta.validation.Valid;

public interface ApiController<Request extends BaseDto, Response extends BaseDto, ID> {
    @GetMapping("/getAll")
    ResponseEntity<List<Response>> getAll();
    @GetMapping("/getById/{id}")
    ResponseEntity<Response> getById(@PathVariable ID id);
    @PostMapping("/add")
    ResponseEntity<Response> add(@Valid @RequestBody Request req);
    @PutMapping("/update/{id}")
    ResponseEntity<Response> update(@PathVariable Long id, @Valid @RequestBody Request req);
    @DeleteMapping("/deleteById/{id}")
    ResponseEntity<Boolean> deleteById(@PathVariable ID id);
}