package com.example.demo.controller;

import com.example.demo.repository.TaskRepository;
import com.example.demo.service.HomeService;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddTaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    HomeService homeService;

    @GetMapping("/addTaskAction")
    public String addTask(@RequestParam String taskName, @RequestParam String newTask, @RequestParam String courseId,@RequestParam String complexity, @RequestParam String standard,  Model model){
        taskService.createTask(newTask, taskName, courseId, complexity, standard);
        homeService.personalPage(model);
        return "home";
    }




}

/*    This application has no explicit mapping for /error, so you are seeing this as a fallback.

        Fri Dec 25 16:55:11 MSK 2020
        There was an unexpected error (type=Not Found, status=404).
        No message available*/
