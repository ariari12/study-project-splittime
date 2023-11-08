package com.study.splittime.todo.controller;

import com.study.splittime.todo.model.ToDoDto;
import com.study.splittime.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @PostMapping("/delete")
    public ResponseEntity<ToDoDto> deleteById(@RequestBody ToDoDto request) throws Exception {
        //나중에 스케줄 ID를 받을지도모르니 dto를 사용했으나 로직은 id만 get()하였으니 알아두자
        ToDoDto toDoDto = toDoService.deleteById(request.getId());
        return ResponseEntity.status(HttpStatus.OK).body(toDoDto);
    }
}
