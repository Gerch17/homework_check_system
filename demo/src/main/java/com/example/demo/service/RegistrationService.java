package com.example.demo.service;

import com.example.demo.entity.Users;
import com.example.demo.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;
    private static int COUNT_ID = 0;

    public void createUser(String password, String userName, String role) {
        Users users = new Users();
        users.setUserId(COUNT_ID++);
        users.setPassword(password);
        users.setUsername(userName);
        users.setEnabled(true);
        users.setRole(role);
        registrationRepository.save(users);
    }

    public String gettingUserName(int id)
    {
        Optional<Users> users = registrationRepository.findById(String.valueOf(id));

        return users.get().getUsername();
    }


    public Iterable<Users> getUsersList()
    {
        Iterable<Users> users = registrationRepository.findAll();

        return users;
    }
}
