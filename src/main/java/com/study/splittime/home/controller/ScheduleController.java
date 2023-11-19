package com.study.splittime.home.controller;

import com.study.splittime.home.model.ScheduleDto;
import com.study.splittime.home.service.ScheduleService;
import com.study.splittime.todo.model.ToDoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/home")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    @GetMapping("")
    public String home(
            Model model
    ) throws Exception
    {
        ScheduleDto scheduleDto = scheduleService.findById(1L); //일단 1로 고정 나중에 시간되면 리스트목록 여러개 추가해보자
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

    @PostMapping("/addList")
    public String create(@RequestBody ScheduleDto scheduleDto){
        log.info("scheduleDto {} ",scheduleDto);
        scheduleService.create(scheduleDto);
        log.info("scheduleDto after {} ",scheduleDto);

        return "redirect:/home";
    }

}
