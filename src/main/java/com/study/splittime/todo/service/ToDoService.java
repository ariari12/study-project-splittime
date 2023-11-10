package com.study.splittime.todo.service;

import com.study.splittime.todo.db.ToDoEntity;
import com.study.splittime.todo.db.ToDoRepository;
import com.study.splittime.todo.model.ToDoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;
    private final ToDoConverter toDoConverter;
    public ToDoDto create(ToDoDto newTodo) throws Exception {
        ToDoEntity entity = toDoConverter.toEntity(newTodo);
        ToDoEntity savedEntity = toDoRepository.save(entity);
        return toDoConverter.toDto(savedEntity);
    }

    public ToDoDto deleteById(Long id) throws Exception {
        log.info("deleteId={}",id);
        Optional<ToDoEntity> toDoEntity = toDoRepository.findById(id);
        ToDoEntity findTarget = toDoEntity.orElseThrow();
        toDoRepository.deleteById(id);
        return toDoConverter.toDto(findTarget);
    }
}
