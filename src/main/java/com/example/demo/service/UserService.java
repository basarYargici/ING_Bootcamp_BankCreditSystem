package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.Users;

import com.example.demo.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by İbrahim Başar YARGICI at 28.09.2021
 */

public interface UserService {


     Set<User> getAll();

     User findUserById(int id);

    User save(User user);

     User update(User user);

     void delete(int id);


}