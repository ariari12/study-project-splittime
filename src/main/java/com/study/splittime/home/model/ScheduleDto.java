package com.study.splittime.home.model;
import com.study.splittime.todo.model.ToDoDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ScheduleDto {
    private Long id;
    private String scheduleName;
    private boolean status;
    private List<ToDoDto> ToDoList;
}
