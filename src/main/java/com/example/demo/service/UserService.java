package com.example.demo.service;

import com.example.demo.dtos.UserRegisterDto;
import com.example.demo.model.User;

import java.util.Set;

/**
 * Created by İbrahim Başar Yargıcı and Emirhan Doğandemir at 29.09.2021
 */
public interface UserService {
    Set<User> getAll();

    User findUserById(long id);

    User save(UserRegisterDto user);

    User save(User user);

    User update(User user);

    void delete(long id);

    User getCredit(long userId, long creditId);
}