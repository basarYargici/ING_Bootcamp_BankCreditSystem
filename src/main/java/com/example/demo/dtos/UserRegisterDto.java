package com.example.demo.dtos;

import com.example.demo.model.User;

/**
 * Created by Emirhan Doğandemir at 29.09.2021
 */
public class UserRegisterDto {
    private String username;
    private String password;
    private String email;

    public User getUserFromDto() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}