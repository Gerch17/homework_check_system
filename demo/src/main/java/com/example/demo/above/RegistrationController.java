package com.example.demo.above;

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
    public String addUser(@RequestParam String userName, @RequestParam String password, Model model){
        registrationService.createUser(password, userName);
        return "home";
    }
}
