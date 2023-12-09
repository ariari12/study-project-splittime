package com.study.splittime.home.controller;

import com.study.splittime.home.model.ScheduleDto;
import com.study.splittime.home.model.ScheduleEntity;
import com.study.splittime.home.service.ScheduleService;
import com.study.splittime.todo.model.ToDoDto;
import com.study.splittime.user.model.UserEntity;
import com.study.splittime.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/home")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final UserService userService;
    @GetMapping("")
    public String home(
            Model model,
            HttpServletRequest request
    ) throws Exception
    {
        HttpSession session = request.getSession();
        var sessionUser =session.getAttribute("loginUser");
        UserEntity loginUser =(UserEntity) sessionUser;

        ScheduleDto scheduleDto = scheduleService.findById(loginUser.getSchedule().getId());
        if(scheduleDto.getToDoList().isEmpty()){
            model.addAttribute("schedule",scheduleDto);
            return "HomeScreenEmptyScreen";
        }else{
            List<ToDoDto> todoList = scheduleDto.getToDoList();
            log.info("=========================================todoList.get={}",todoList.stream().iterator());
            model.addAttribute("schedule",scheduleDto);
            model.addAttribute("todoList",todoList);
            return "HomeScreenScheduleScreen";
        }
    }
    @GetMapping("/calendar")
    public String calendarView(
            Model model
    ) throws Exception
    {
        ScheduleDto scheduleDto = scheduleService.findById(1L); //일단 1로 고정 나중에 시간되면 리스트목록 여러개 추가해보자
        if (scheduleDto.getToDoList().isEmpty()){
            model.addAttribute("schedule",scheduleDto);
        }else {
            List<ToDoDto> todoList = scheduleDto.getToDoList();
            log.info("=========================================todoList.get={}",todoList.get(0).getTodo());
            model.addAttribute("todoList",todoList);
            model.addAttribute("schedule",scheduleDto);
        }

        return "Calendar";

    }

    @PostMapping("/addSchedule/{userId}")
    public String create(@PathVariable Long userId) throws Exception {
        UserEntity userEntity = userService.findById(userId);
        ScheduleDto scheduleDto = ScheduleDto.builder().userEntity(userEntity).build();
        log.info("scheduleDto {} ",scheduleDto);
        ScheduleEntity scheduleEntity = scheduleService.create(scheduleDto);

        return "redirect:/login";
    }

}
