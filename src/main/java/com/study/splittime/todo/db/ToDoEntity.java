package com.study.splittime.todo.db;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.study.splittime.home.db.ScheduleEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity(name = "todo")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ToDoEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "todo")
    private ScheduleEntity scheduleEntity;

    private String name;
    private String description;
    private LocalDate created;
    private LocalDate dueDate;
    private boolean completed=false;
    private boolean status;
}
