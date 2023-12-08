package com.study.splittime.user.service;

import com.study.splittime.user.db.UserRepository;
import com.study.splittime.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void register(UserEntity userEntity){
        userRepository.save(userEntity);
    }
}
