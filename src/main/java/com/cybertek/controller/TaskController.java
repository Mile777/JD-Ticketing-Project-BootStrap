package com.cybertek.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Task Create Step 1.
@Controller
@RequestMapping("/task")
public class TaskController {

    @GetMapping("/create")
    public String createTask(){

        return "task/create";
    }
}
