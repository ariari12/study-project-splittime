package com.study.splittime.user.model;

import com.study.splittime.home.model.ScheduleEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;

    @OneToOne(mappedBy = "userEntity")
    private ScheduleEntity schedule;
}
