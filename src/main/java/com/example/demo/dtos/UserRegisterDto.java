package com.example.demo.dtos;

import com.example.demo.model.User;

/**
 * Created by Emirhan Doğandemir at 29.09.2021
 */
public class UserRegisterDto {
    private String username;
    private String email;
    private String password;

    public User getUserFromDto() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}