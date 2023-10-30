package com.study.splittime.home.db;

import com.study.splittime.todo.db.ToDoEntity;
import com.study.splittime.todo.model.ToDoDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity(name = "schedule")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String scheduleName;

    private boolean status;
    @OneToMany(mappedBy = "scheduleEntity")
    private List<ToDoEntity> todo;


}
