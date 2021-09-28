package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by İbrahim Başar YARGICI at 28.09.2021
 */
// this is a test class to see if API is working
@RestController
@RequestMapping("/welcome")
public class WelcomeController {
    @GetMapping("/")
    private ResponseEntity<String> get() {
        return ResponseEntity.ok("Welcome");
    }
}
