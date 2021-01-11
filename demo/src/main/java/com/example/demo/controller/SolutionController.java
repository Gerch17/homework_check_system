//package com.example.demo.controller;
//
//import com.example.demo.repository.SolutionRepository;
//import com.example.demo.service.TaskService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class SolutionController {
//    @Autowired
//    private SolutionRepository solutionRepository;
//
//    @Autowired
//    private TaskService taskService;
//
//    @GetMapping("/task")
//    public String addSolution(@RequestParam String newSolution){
//        taskService.createSolution(newSolution);
//        return "home";
//    }
//
//}
