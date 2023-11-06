package com.study.splittime.home.controller;

import com.study.splittime.home.model.ScheduleDto;
import com.study.splittime.home.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/home")
@RequiredArgsConstructor
public class ScheduleApiController {
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
            model.addAttribute("schedule",scheduleDto);
            return "HomeScreenScheduleScreen";
        }
    }

    @PostMapping("/addList")
    public String create(@RequestBody ScheduleDto scheduleDto){
        log.info("scheduleDto {} ",scheduleDto);
        scheduleService.create(scheduleDto);
        log.info("scheduleDto after {} ",scheduleDto);

        return "redirect:/home";
    }

}
