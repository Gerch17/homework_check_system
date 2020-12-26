package com.example.demo.above;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Entity
@Data
public class Registration {

    @Id
    private String userId;

    private String userName;

    private String password;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String taskId) {
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
