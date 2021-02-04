package com.example.demo.controller;

import com.example.demo.service.TaskService;
import com.example.demo.service.TestService;
import com.example.demo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddTestController {

    @Autowired
    private TestService testService;

    @Autowired
    private TaskService taskService;

    @Autowired
    HomeService homeService;

    @GetMapping("/addtest")
    public String getTestList(Model model)
    {
        model.addAttribute("tasks", taskService.getTasks());
        return "addtest";
    }

    @GetMapping("/addTestAction")
    public String addTest(@RequestParam String taskName,@RequestParam String inputData,@RequestParam String outputData, Model model){
        testService.addTest(taskName, inputData, outputData);
        homeService.personalPage(model);
        return "home";
    }
}
