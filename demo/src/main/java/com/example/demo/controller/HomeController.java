package com.example.demo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.metamodel.Type;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    HomeService homeService;

    @GetMapping("/")
    public String home(Model model) {
        homeService.personalPage(model);
        return "home";
    }

    @GetMapping("/addtask")
    public String addTask(){
        return "addtask";
    }

    @GetMapping("/registration.html")
    public String addUser(){
        return "registration";
    }
    @GetMapping ("/auth")
    public String login(){
        return "login";
    }
}
