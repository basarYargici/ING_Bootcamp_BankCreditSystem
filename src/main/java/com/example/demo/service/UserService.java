package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

/**
 * Created by İbrahim Başar YARGICI at 28.09.2021
 */
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser(long id) {
        User user = userRepository.getById(id);

        return user;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        // TODO business code
        return userRepository.save(user);
    }

    public void delete(long id) {
        // TODO business code
        userRepository.delete(findUser(id));
    }
}