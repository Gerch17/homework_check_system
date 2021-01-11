package com.example.demo.controller;

import com.example.demo.repository.RegistrationRepository;
import com.example.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private RegistrationRepository registrationRepository;

    @GetMapping("/registration")
    public String addUser(@RequestParam String userName, @RequestParam String password,@RequestParam String role, Model model){
        registrationService.createUser(password, userName, role);
        return "/home";
    }
}
