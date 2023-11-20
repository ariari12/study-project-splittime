package com.study.splittime.todo.service;

import com.study.splittime.todo.db.ToDoEntity;
import com.study.splittime.todo.db.ToDoRepository;
import com.study.splittime.todo.model.ToDoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;
    private final ToDoConverter toDoConverter;
    @Transactional
    public ToDoDto create(ToDoDto newTodo) throws Exception {
        ToDoEntity entity = toDoConverter.toEntity(newTodo);
        ToDoEntity savedEntity = toDoRepository.save(entity);
        return toDoConverter.toDto(savedEntity);
    }

    @Transactional
    public ToDoDto update(ToDoDto editTodo) throws Exception {
        var entity = toDoConverter.toEntity(editTodo);
        if (entity != null) {
            entity = toDoRepository.save(entity);
            return toDoConverter.toDto(entity);
        } else {
            throw new IllegalArgumentException("Entity가 null이라 update 못함");
        }
    }
    @Transactional
    public ToDoDto deleteById(Long id) throws Exception {
        log.info("deleteId={}",id);
        Optional<ToDoEntity> toDoEntity = toDoRepository.findById(id);
        ToDoEntity findTarget = toDoEntity.orElseThrow();
        toDoRepository.deleteById(id);
        return toDoConverter.toDto(findTarget);
    }
}
