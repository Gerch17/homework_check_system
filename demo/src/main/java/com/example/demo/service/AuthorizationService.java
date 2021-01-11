package com.example.demo.service;

import com.example.demo.entity.Registration;
import com.example.demo.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorizationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public boolean checkUser(String password, String userName) {
        Iterable<Registration> registration = registrationRepository.findAll();
        for (Registration user : registration) {
            if(user.getUserName().equals(userName) && user.getPassword().equals(password)){
                System.out.println("успшная авторизация");
                return true;
            }
        }
        System.out.println("ошибка авторизации");
        return false;
    }
}
