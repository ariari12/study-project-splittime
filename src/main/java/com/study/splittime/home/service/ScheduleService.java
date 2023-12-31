package com.study.splittime.home.service;

import com.study.splittime.home.model.ScheduleEntity;
import com.study.splittime.home.db.ScheduleRepository;
import com.study.splittime.home.model.ScheduleDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final ScheduleConverter scheduleConverter;


    public ScheduleDto findById(Long id) throws Exception {
        Optional<ScheduleEntity> entity = scheduleRepository.findById(id);
        if(entity.isPresent()){
            ScheduleEntity scheduleEntity = entity.get();
            return scheduleConverter.toDto(scheduleEntity); //엔티티를 dto로 바꿔주고 리턴
        }else {
            return null;
        }
    }

    public ScheduleEntity create(ScheduleDto scheduleDto) {
        ScheduleEntity entity = scheduleConverter.toEntity(scheduleDto);
        return scheduleRepository.save(entity);
    }
}
