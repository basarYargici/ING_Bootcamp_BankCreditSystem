package com.example.demo.service;

import com.example.demo.model.Credit;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by İbrahim Başar YARGICI at 28.09.2021
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Set<User> getAll() {
        return new HashSet<>(userRepository.findAll());
    }

    public User findUserById(long id) {
        // TODO business code
        return userRepository.getById(id);
    }

    public User save(User user) {
        // TODO business code
        return userRepository.save(user);
    }

    public User update(User user) {
        // TODO business code
        return userRepository.save(user);
    }

    public void delete(long id) {
        // TODO business code
        userRepository.delete(findUserById(id));
    }
}