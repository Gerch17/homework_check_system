package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class AddSolutionController {
    @Autowired
    private TaskService taskService;
    private String taskID;

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    @GetMapping("/addSolution")
    public String addSolution(@RequestParam String newSolution, Model model){
        taskService.createSolution(newSolution,taskID);
        return "home";
    }
}
