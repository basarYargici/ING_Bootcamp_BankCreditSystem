package com.example.demo.controller;

import com.example.demo.dtos.UserRegisterDto;
import com.example.demo.dtos.converter.UserRegisterDtoConverter;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

/**
 * Created by İbrahim Başar YARGICI at 29.09.2021
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserRegisterDtoConverter userRegisterDtoConverter;

    public UserController(UserService userService, UserRegisterDtoConverter userRegisterDtoConverter) {
        this.userService = userService;
        this.userRegisterDtoConverter = userRegisterDtoConverter;
    }

    @GetMapping("/getAll")
    public Set<User> findCreditById() {
        // TODO business code
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable int id) {
        // TODO business code
        return this.userService.findUserById(id);
    }

    @PostMapping("/add")
    public User save(@Valid UserRegisterDto user) {
        // TODO business code
        return userService.save(user);
    }

    @PostMapping("/update")
    public User update(UserRegisterDto user) {
        // TODO business code
        return userService.save(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete")
    public void delete(int id) {
        // TODO business code
        userService.delete(id);
    }
}