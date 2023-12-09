package com.study.splittime.user.service;

import com.study.splittime.user.db.UserRepository;
import com.study.splittime.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void register(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public UserEntity login(
            UserEntity userEntity
    ) throws Exception {
        var entity = getUserWithThrow(userEntity.getName(), userEntity.getPassword());
        return entity;

    }

    public UserEntity findById(Long id) throws Exception {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.orElseThrow(() -> new Exception("null값임"));
    }

    public UserEntity getUserWithThrow(
            String name,
            String password
    ) throws Exception {
        return userRepository.findFirstByNameAndPasswordOrderByIdDesc(
                name,
                password
        ).orElseThrow(()-> new Exception("User를 찾을 수 없음"));
    }
}
