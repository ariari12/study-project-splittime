package com.study.splittime.user.controller;

import com.study.splittime.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/register")
    public String registerView(){
        return "RegisterScreen";
    }

    @PostMapping("/register")
    public String register(UserEntity userEntity){

        return "LoginScreen";
    }

    @PostMapping("/")
    public String login(){

    }
}
