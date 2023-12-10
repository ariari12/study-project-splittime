package com.study.splittime.todo.service;

import com.study.splittime.home.model.ScheduleEntity;
import com.study.splittime.home.db.ScheduleRepository;
import com.study.splittime.todo.db.ToDoEntity;
import com.study.splittime.todo.db.ToDoRepository;
import com.study.splittime.todo.model.ToDoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ToDoConverter {
    private final ScheduleRepository scheduleRepository;
    private final ToDoRepository toDoRepository;
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

    public ToDoDto patch(ToDoDto dto, Long id) {
        ToDoEntity entity = toDoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id값과 같은 엔티티가 없습니다"));
        log.info("patch entity = {}",entity);
        ToDoDto target = toDto(entity);
        log.info("patch target = {}",target);

        // 객체를 갱신

        target.setTodo(dto.getTodo());
        target.setCompleted(dto.isCompleted());
        target.setCreated(dto.getCreated());
        target.setDueDate(dto.getDueDate());
        target.setPriority(dto.isPriority());
        log.info("return target={}",target);
        return target;

    }
}
