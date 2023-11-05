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
                .todo(toDoEntity.getTodo())
                .scheduleId(toDoEntity.getScheduleEntity().getId())
                .created(toDoEntity.getCreated())
                .dueDate(toDoEntity.getDueDate())
                .completed(toDoEntity.isCompleted())
                .priority(toDoEntity.isPriority())
                .build();

    }
    public ToDoEntity toEntity(ToDoDto toDoDto) throws Exception {
        Optional<ScheduleEntity> scheduleEntity = scheduleRepository.findById(toDoDto.getScheduleId());

        if(scheduleEntity.isPresent()){
            return ToDoEntity.builder()
                    .id(toDoDto.getId())
                    .todo(toDoDto.getTodo())
                    .scheduleEntity(scheduleEntity.get())
                    .created(toDoDto.getCreated())
                    .dueDate(toDoDto.getDueDate())
                    .completed(toDoDto.isCompleted())
                    .priority(toDoDto.isPriority())
                    .build();
        }else {
            throw new Exception("scheduleEntity id 값이 null 임");
        }


    }
}
