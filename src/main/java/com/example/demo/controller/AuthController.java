package com.example.demo.controller;

import com.example.demo.config.jwt.TokenProvider;
import com.example.demo.dtos.UserLoginDto;
import com.example.demo.dtos.UserRegisterDto;
import com.example.demo.model.AuthToken;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Emirhan Doğandemir at 30.09.2021
 */

@RestController
@RequestMapping("/api/auth/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<?> generateToken(@RequestBody UserLoginDto loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }



    @RequestMapping(value="/register", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserRegisterDto user){

        return userService.save(user);
    }



}
