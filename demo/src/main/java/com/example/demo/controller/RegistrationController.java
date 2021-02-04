package com.example.demo.controller;

import com.example.demo.entity.Score;
import com.example.demo.entity.Users;
import com.example.demo.repository.RegistrationRepository;
import com.example.demo.service.RegistrationService;
import com.example.demo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private RegistrationRepository registrationRepository;


    @Autowired
    HomeService homeService;

    private long ID;

    @GetMapping("/user/{id}")
    public String user(@PathVariable("id") String id, Model model) {
        ID = Integer.parseInt(id);
        String userName = registrationService.gettingUserName(Integer.parseInt(id));
        String userRole = registrationService.gettingUserRole(Integer.parseInt(id));
        model.addAttribute("username", userName);
        model.addAttribute("userrole", userRole);
        return "user";
    }

    @GetMapping("/userrole")
    public String change(@RequestParam String role, Model model) {
        registrationService.changeRole(ID, role);
        String userName = registrationService.gettingUserName(ID);
        String userRole = registrationService.gettingUserRole(ID);
        model.addAttribute("username", userName);
        model.addAttribute("userrole", userRole);
        return "user";
    }

    @GetMapping("/registrationAction")
    public String addUser(@RequestParam String userName, @RequestParam String password,@RequestParam String role, Model model){
        registrationService.createUser(password, userName, role);
        homeService.personalPage(model);
        return "home";
    }


    @GetMapping("/rating")
    public String rating(Model model){
        registrationService.ratingList(model);
        return "rating";
    }
}
