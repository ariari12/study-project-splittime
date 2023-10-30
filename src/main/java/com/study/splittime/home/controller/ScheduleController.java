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
@RequestMapping("/")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    @GetMapping("/{id}")
    public String home(
            @PathVariable Long id,
            Model model
    ) throws Exception
    {
        ScheduleDto scheduleDto = scheduleService.findById(id);
        model.addAttribute("",scheduleDto.getScheduleName());

        return "home/HomeScreen";
    }

    @PostMapping("/addList")
    public String create(ScheduleDto scheduleDto){
        log.info("scheduleDto {} ",scheduleDto);
        scheduleService.create(scheduleDto);
        log.info("scheduleDto after {} ",scheduleDto);

        return "redirect:/1";
    }

}
