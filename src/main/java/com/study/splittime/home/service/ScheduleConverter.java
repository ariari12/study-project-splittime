package com.study.splittime.home.service;

import com.study.splittime.home.db.ScheduleEntity;
import com.study.splittime.home.model.ScheduleDto;
import org.springframework.stereotype.Service;

@Service
public class ScheduleConverter {
    public ScheduleDto toDto(ScheduleEntity scheduleEntity){
        return ScheduleDto.builder()
                .scheduleName(scheduleEntity.getScheduleName())
                .id(scheduleEntity.getId())
                .build();

    }
    public ScheduleEntity toEntity(ScheduleDto scheduleDto){
        return ScheduleEntity.builder()
                .scheduleName(scheduleDto.getScheduleName())
                .id(scheduleDto.getId())
                .build();

    }
}
