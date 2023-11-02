package com.study.splittime.todo.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ToDoDto {
    private Long id;
    private Long scheduleId;
    private String name;
    private String description;
    private LocalDate created;
    private LocalDate dueDate;
    private boolean completed=false;
    private boolean status;
}
