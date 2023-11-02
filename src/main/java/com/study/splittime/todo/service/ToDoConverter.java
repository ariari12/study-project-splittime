package com.study.splittime.todo.service;

import com.study.splittime.home.db.ScheduleEntity;
import com.study.splittime.home.db.ScheduleRepository;
import com.study.splittime.home.model.ScheduleDto;
import com.study.splittime.todo.db.ToDoEntity;
import com.study.splittime.todo.model.ToDoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ToDoConverter {
    private final ScheduleRepository scheduleRepository;
    public ToDoDto toDto(ToDoEntity toDoEntity){

        return ToDoDto.builder()
                .id(toDoEntity.getId())
                .name(toDoEntity.getName())
                .scheduleId(toDoEntity.getScheduleEntity().getId())
                .description(toDoEntity.getDescription())
                .created(toDoEntity.getCreated())
                .dueDate(toDoEntity.getDueDate())
                .completed(toDoEntity.isCompleted())
                .status(toDoEntity.isStatus())
                .build();

    }
    public ToDoEntity toEntity(ToDoDto toDoDto) throws Exception {
        Optional<ScheduleEntity> byId = scheduleRepository.findById(toDoDto.getScheduleId());
        if(byId.isPresent()){
            ScheduleEntity scheduleEntity = byId.get();
            return ToDoEntity.builder()
                    .id(toDoDto.getId())
                    .name(toDoDto.getName())
                    .scheduleEntity(toDoDto.getScheduleId())
                    .description(toDoDto.getDescription())
                    .created(toDoDto.getCreated())
                    .dueDate(toDoDto.getDueDate())
                    .completed(toDoDto.isCompleted())
                    .status(toDoDto.isStatus())
                    .build();
        }else {
            throw new Exception("scheduleEntity id 값이 null 임");
        }


    }
}
