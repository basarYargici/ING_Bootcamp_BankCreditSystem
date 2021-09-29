package com.example.demo.service;

import com.example.demo.model.User;

import java.util.Set;

/**
 * Created by Emirhan Doğandemir at 29.09.2021
 */
public interface UserService {
    Set<User> getAll();

    User findUserById(int id);

    User save(User user);

    User update(User user);

    void delete(int id);
}