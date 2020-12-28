package com.example.demo.entity;

import com.example.demo.repository.RegistrationRepository;
import com.example.demo.service.RegistrationService;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Registration {

    @Id
    private long userId;

    private String userName;

    private String password;

    public Registration(){}

    public Registration(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long taskId) {
        this.userId = taskId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
