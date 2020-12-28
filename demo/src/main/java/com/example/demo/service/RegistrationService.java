package com.example.demo.service;

import com.example.demo.entity.Registration;
import com.example.demo.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;
    private static int COUNT_ID = 0;

    public void createUser(String password, String userName) {
        Registration registration = new Registration();
        registration.setUserId(String.valueOf(COUNT_ID++));
        registration.setPassword(password);
        registration.setUserName(userName);
        registrationRepository.save(registration);
    }

    public String gettingUserName(int id)
    {
        Optional<Registration> registration = registrationRepository.findById(String.valueOf(id));

        return registration.get().getUserName();
    }


    public Iterable<Registration> getUsersList()
    {
        Iterable<Registration> registration = registrationRepository.findAll();

        return registration;
    }
}
