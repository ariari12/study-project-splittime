package com.study.splittime.home.controller;

import com.study.splittime.home.model.ScheduleDto;
import com.study.splittime.home.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
        scheduleService.create(scheduleDto);

        return "redirect:/1";
    }

}
