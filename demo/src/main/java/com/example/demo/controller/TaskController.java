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

/*    @GetMapping("/tasks")
    public String task(Model model) {
        final Iterable<Task> tasks = taskService.getTasks();
        model.addAttribute("tasks", tasks);
        model.addAttribute("count", taskRepository.count());
        return "task";
    }*/

    @GetMapping("/task/{id}")
    public String Hello(@PathVariable("id") String id, Model model)
    {
        int ID = Integer.parseInt(id);
        model.addAttribute("greeting", taskService.gettingTask(ID));
        return "task";
    }

    @GetMapping("/tasks")
    public String TaskList (Model model) {
        model.addAttribute("task", taskService.getTaskList());
        return "tasks";
    }
}
