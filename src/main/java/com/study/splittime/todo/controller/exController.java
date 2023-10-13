package com.study.splittime.todo.controller;

import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Controller
//@SpringBootApplication
public class exController {

    // 가상의 모델 데이터 (백엔드에서 받아온 것으로 가정)
    private final List<List<Todo>> todoLists = new ArrayList<>();
    private final List<Todo> newTodoList = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        // 초기 모델 데이터 설정
        todoLists.add(Arrays.asList(
                new Todo(1, "할 일 1", null),
                new Todo(2, "할 일 2", null)
        ));

        // 모델 데이터 설정
        model.addAttribute("todoLists", todoLists);
        model.addAttribute("newTodoList", newTodoList);

        return "home/HomeScreen"; // Thymeleaf 템플릿 경로
    }

    // 추가된 부분: 새로운 목록 추가 (POST 요청)
    @PostMapping("/addList")
    public String addNewList(Model model) {
        todoLists.add(new ArrayList<>());
        model.addAttribute("todoLists", todoLists);
        model.addAttribute("newTodoList", newTodoList);

        return "redirect:/"; // 홈 화면으로 리다이렉트
    }

    // 추가된 부분: 할 일 추가 (POST 요청)
    @PostMapping("/addTodo")
    public String addTodo(Todo newTodo, RedirectAttributes rttr) {
        newTodoList.add(newTodo);
        rttr.addAttribute("todoLists", todoLists);
        rttr.addAttribute("newTodoList", newTodoList);

        return "redirect:/"; // 홈 화면으로 리다이렉트
    }

    public static void main(String[] args) {
        SpringApplication.run(exController.class, args);
    }
    @Getter
    private static class Todo {
        private final int id;
        private final String text;
        private final LocalDate dueDate;

        public Todo(int id, String text, LocalDate dueDate) {
            this.id = id;
            this.text = text;
            this.dueDate = dueDate;
        }
    }
}