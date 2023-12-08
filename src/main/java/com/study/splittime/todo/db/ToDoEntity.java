package com.study.splittime.todo.db;

import com.study.splittime.home.model.ScheduleEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

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
    @ToString.Exclude
    @JoinColumn(name = "schedule_id")
    private ScheduleEntity scheduleEntity;

    private String todo;
    private LocalDate created;
    private LocalDate dueDate;
    private boolean completed=false;
    private boolean priority;
}
