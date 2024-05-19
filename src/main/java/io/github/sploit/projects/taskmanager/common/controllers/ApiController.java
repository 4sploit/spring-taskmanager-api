package io.github.sploit.projects.taskmanager.common.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import io.github.sploit.projects.taskmanager.common.dtos.BaseDto;

public interface ApiController<Request extends BaseDto, Response extends BaseDto, ID> {
    @GetMapping("/getAll")
    List<Response> getAll();
    @GetMapping("/getById/id")
    Response getById(ID id);
    @PostMapping("/add")
    Response add(Request req);
    @PutMapping("/update/{id}")
    Response update(ID id, Request req);
    @DeleteMapping("/deleteById/{id}")
    Boolean deleteById(ID id);
}