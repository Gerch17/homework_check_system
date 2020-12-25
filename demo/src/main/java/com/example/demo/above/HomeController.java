package com.example.demo.above;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String home() {
        taskService.createTask("Условие задачи", "Название");
        return "home";
    }

    @GetMapping("/task.html")
    public String task()
    {
        return "task";
    }

    @GetMapping("/addtask.html")
    public String addTask(){
        return "addtask";
    }

}
