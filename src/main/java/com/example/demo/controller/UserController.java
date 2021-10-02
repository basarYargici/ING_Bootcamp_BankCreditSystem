package com.example.demo.controller;

import com.example.demo.dtos.UserDto;
import com.example.demo.dtos.UserRegisterDto;
import com.example.demo.dtos.converter.UserRegisterDtoConverter;
import com.example.demo.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by İbrahim Başar Yargıcı and Emirhan Doğandemir at 29.09.2021
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
    public Set<UserDto> findCreditById() {
        return userService.getAll().stream().map(userRegisterDtoConverter::convertToUserDto).collect(Collectors.toSet());
    }

    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable long id) {
        return userRegisterDtoConverter.convertToUserDto(userService.findUserById(id));
    }

    @PostMapping("/add")
    public UserDto save(@Valid @RequestBody UserRegisterDto user) {
        return userRegisterDtoConverter.convertToUserDto(userService.save(user));
    }

    @PostMapping("/update")
    public UserDto update(@Valid @RequestBody UserRegisterDto user) {
        return userRegisterDtoConverter.convertToUserDto(userService.save(user));
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

    @GetMapping("/getCredit/{userId}/{creditId}")
    public UserDto getCredit(@PathVariable long userId, @PathVariable long creditId) {
        return userRegisterDtoConverter.convertToUserDto(userService.getCredit(userId, creditId));
    }
}