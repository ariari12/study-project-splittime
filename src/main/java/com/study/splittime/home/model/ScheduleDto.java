package com.study.splittime.home.model;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.study.splittime.todo.model.ToDoDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ScheduleDto {
    private Long id;
    private String scheduleName;
    private List<ToDoDto> toDoList;
}
