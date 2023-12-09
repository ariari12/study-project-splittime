package com.study.splittime.user.db;

import com.study.splittime.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findFirstByNameAndPasswordOrderByIdDesc(String name, String password);
}
