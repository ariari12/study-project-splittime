package com.study.splittime.todo.controller;

import com.study.splittime.todo.model.ToDoDto;
import com.study.splittime.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class ToDoApiController {
    private final ToDoService toDoService;
    @PostMapping("/addTodo")
    public ResponseEntity<ToDoDto> addTodo(@RequestBody ToDoDto newTodo) throws Exception {
        ToDoDto savedDto= toDoService.create(newTodo);
        return ResponseEntity.status(HttpStatus.OK).body(savedDto);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ToDoDto> deleteById(@PathVariable Long id) throws Exception {
        ToDoDto toDoDto = toDoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(toDoDto);
    }
}
