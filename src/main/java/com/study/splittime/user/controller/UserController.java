package com.study.splittime.user.controller;

import com.study.splittime.user.model.UserEntity;
import com.study.splittime.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/register")
    public String registerView(){
        return "RegisterScreen";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserEntity userEntity) throws Exception {
        log.info("********** userEntity={}",userEntity.toString());
        userService.register(userEntity);
        UserEntity user = userService.findById(userEntity.getId());
        return "forward:/home/addSchedule/"+user.getId();
    }

    @GetMapping("/login")
    public String loginView(){
        return "LoginScreen";
    }

    @PostMapping("/login")
    public String login(HttpSession session, UserEntity userEntity) throws Exception {

        UserEntity user=userService.login(userEntity);
        session.setMaxInactiveInterval(-1);
        session.setAttribute("loginUser",user);
        var loginUser=session.getAttribute("loginUser");
        log.info("----------------{}",loginUser);

        return "redirect:/home";
    }
}
