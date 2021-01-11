package com.example.demo.controller;

import com.example.demo.service.AuthorizationService;
import com.example.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;

    @GetMapping("/authorizationCheck")
    public String authorizationCheck(@RequestParam String userName, @RequestParam String password){
        authorizationService.checkUser(password, userName);
        return "home";
    }

    @GetMapping("/authorization.html")
    public String authorizationPage(){
        return "authorization";
    }
}
