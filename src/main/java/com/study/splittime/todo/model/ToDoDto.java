package com.study.splittime.todo.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
