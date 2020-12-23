package com.cybertek.controller;


import com.cybertek.dto.TaskDTO;
import com.cybertek.enums.Status;
import com.cybertek.service.ProjectService;
import com.cybertek.service.TaskService;
import com.cybertek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.UUID;

// Task Create Step 1.
@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @GetMapping("/create")
    public String createTask(Model model){

        model.addAttribute("task", new TaskDTO());

        model.addAttribute("projects", projectService.findAll());

        model.addAttribute("employees", userService.findEmloyees());

        model.addAttribute("tasks", taskService.findAll());

        return "task/create";
    }

    @PostMapping("/create")
    public String insertTask(Model model, TaskDTO task){

        task.setTaskStatus(Status.OPEN);
        task.setAssignedDate(LocalDate.now());

        task.setId(UUID.randomUUID().getMostSignificantBits());

        System.out.println(" Auto Generated ID  "+task.getId());

        taskService.save(task);
        return "redirect:/task/create";
    }

    @GetMapping("/delete/{id}") // We need something unique, which is 'id' in this case
    public String deleteTask(@PathVariable("id") Long id){

        taskService.deleteById(id);

        return "redirect:/task/create";
    }

    @GetMapping("update/{id}")
    public String editTask(@PathVariable("id") Long id, Model model){

        model.addAttribute("task", taskService.findById(id)); // looking for a specific object found by ID

        model.addAttribute("projects", projectService.findAll());// passing All objects/Projects inside drop-down

        model.addAttribute("employees", userService.findEmloyees());// passing all objects/Employees inside drop-down

        model.addAttribute("tasks", taskService.findAll());//

        return "task/update";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable("id") Long id, TaskDTO task, Model model){

        taskService.update(task);

        // since we are repeating the action we don't need retype 'model.Attribute for task, projects, employees, tasks...
        // we can 'redirect'/navigate to the view: task/create,
        return "redirect:/task/create";

    }

}





