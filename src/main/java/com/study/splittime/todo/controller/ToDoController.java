package com.study.splittime.todo.controller;

import com.study.splittime.todo.model.ToDoDto;
import com.study.splittime.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;
    @PostMapping("/addTodo")
    public String addTodo(ToDoDto newTodo, RedirectAttributes rttr) throws Exception {
        toDoService.create(newTodo);

        return "redirect:/"; // 홈 화면으로 리다이렉트
    }
}
