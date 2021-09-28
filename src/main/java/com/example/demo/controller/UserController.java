package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by İbrahim Başar YARGICI at 29.09.2021
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public Set<User> findCreditById() {
        // TODO business code
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable long id) {
        // TODO business code
        return userService.findUserById(id);
    }

    @PostMapping("/add")
    public User save(User user) {
        // TODO business code
        return userService.save(user);
    }

    @PostMapping("/update")
    public User update(User user) {
        // TODO business code
        return userService.save(user);
    }

    @DeleteMapping("/delete")
    public void delete(long id) {
        // TODO business code
        userService.delete(id);
    }
}