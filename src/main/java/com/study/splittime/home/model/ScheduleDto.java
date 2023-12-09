package com.study.splittime.home.model;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.study.splittime.todo.model.ToDoDto;
import com.study.splittime.user.model.UserEntity;
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
    private UserEntity userEntity;
    private List<ToDoDto> toDoList;

}
