package com.study.splittime.home.model;

import com.study.splittime.todo.db.ToDoEntity;
import com.study.splittime.user.model.UserEntity;
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

    @OneToOne
    @ToString.Exclude
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "scheduleEntity")
    private List<ToDoEntity> todo;


}
