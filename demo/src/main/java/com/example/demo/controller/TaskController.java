package com.example.demo.controller;

import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AddSolutionController addSolutionController;

    @GetMapping("/task/{id}")
    public String task(@PathVariable("id") String id, Model model){
        addSolutionController.setTaskID(id);
        int ID = Integer.parseInt(id);
        model.addAttribute("greeting", taskService.gettingTask(ID));
        model.addAttribute("statement", taskService.getStatement(id));
        return "task";
    }

    @GetMapping("/tasks/{id}")
    public String TaskList (@PathVariable("id") String courseId, Model model) {
        model.addAttribute("tasks", taskService.getTaskList(courseId));
        return "tasks";
    }

