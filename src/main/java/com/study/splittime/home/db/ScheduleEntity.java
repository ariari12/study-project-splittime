package com.study.splittime.home.db;

import com.study.splittime.todo.model.ToDoDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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


}
