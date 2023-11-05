package com.study.splittime.todo.service;

import com.study.splittime.todo.db.ToDoEntity;
import com.study.splittime.todo.db.ToDoRepository;
import com.study.splittime.todo.model.ToDoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;
    private final ToDoConverter toDoConverter;
    public ToDoDto create(ToDoDto newTodo) throws Exception {
        ToDoEntity entity = toDoConverter.toEntity(newTodo);
        ToDoEntity savedEntity =toDoRepository.save(entity);
        return toDoConverter.toDto(savedEntity);
        //
    }
}
