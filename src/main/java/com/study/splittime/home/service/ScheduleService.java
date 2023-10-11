package com.study.splittime.home.service;

import com.study.splittime.home.db.ScheduleEntity;
import com.study.splittime.home.db.ScheduleRepository;
import com.study.splittime.home.model.ScheduleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final ScheduleConverter scheduleConverter;

    public ScheduleDto findById(Long id) throws Exception {
        Optional<ScheduleEntity> byId = scheduleRepository.findById(id);
        if(byId.isPresent()){
            ScheduleEntity scheduleEntity = byId.get();
            return scheduleConverter.toDto(scheduleEntity); //엔티티를 dto로 바꿔주고 리턴
        }else {
            throw new Exception("scheduleEntity id 값이 null 임");
        }
    }

    public void create(ScheduleDto scheduleDto) {
        ScheduleEntity entity = scheduleConverter.toEntity(scheduleDto);
        scheduleRepository.save(entity);
    }
}
