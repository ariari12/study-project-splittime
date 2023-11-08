package com.study.splittime.home.service;

import com.study.splittime.home.db.ScheduleEntity;
import com.study.splittime.home.model.ScheduleDto;
import com.study.splittime.todo.model.ToDoDto;
import com.study.splittime.todo.service.ToDoConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleConverter {
    private final ToDoConverter toDoConverter;
    public ScheduleDto toDto(ScheduleEntity scheduleEntity){

        List<ToDoDto> toDoList = scheduleEntity.getTodo()
                .stream()
                .map(it -> toDoConverter.toDto(it))
                .collect(Collectors.toList());

        return ScheduleDto.builder()
                .scheduleName(scheduleEntity.getScheduleName())
                .id(scheduleEntity.getId())
                .toDoList(toDoList)
                .build();

    }
    public ScheduleEntity toEntity(ScheduleDto scheduleDto){
        return ScheduleEntity.builder()
                .scheduleName(scheduleDto.getScheduleName())
                .id(scheduleDto.getId())
                .build();

    }
}
