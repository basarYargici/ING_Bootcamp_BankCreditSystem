package com.example.demo.service.impl;

import com.example.demo.config.MyUserDetails;
import com.example.demo.config.PasswordConfig;
import com.example.demo.dtos.UserRegisterDto;
import com.example.demo.dtos.converter.UserRegisterDtoConverter;
import com.example.demo.exception.CustomNotFoundException;
import com.example.demo.exception.CustomNotSavedException;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Emirhan Doğandemir at 29.09.2021
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    private final RoleService roleService;

    private final PasswordConfig passwordConfig;
    private final UserRegisterDtoConverter userRegisterDtoConverter;

    public UserServiceImpl(UserRepository userRepository,
                           RoleService roleService,
                           PasswordConfig passwordConfig,
                           UserRegisterDtoConverter userRegisterDtoConverter) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordConfig = passwordConfig;
        this.userRegisterDtoConverter = userRegisterDtoConverter;
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    @Override
    public Set<User> getAll() {
        return new HashSet<>(userRepository.findAll());
    }

    @Override
    public User findUserById(long id) {
        try {
            return userRepository.getById(id);
        } catch (Exception exception) {
            throw new CustomNotFoundException("User could not be found with id: " + id);
        }
    }

    @Override
    public User save(UserRegisterDto user) {

        try {
            User newUser = userRegisterDtoConverter.convertToUser(user);

            newUser.setPassword(passwordConfig.passwordEncoder().encode(user.getPassword()));

            Role role = roleService.findRoleByName("USER");
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(role);

            if (newUser.getEmail().split("@")[1].equals("admin.edu")) {
                role = roleService.findRoleByName("ADMIN");
                roleSet.add(role);
            }
            newUser.setRoles(roleSet);
            return userRepository.save(newUser);

        } catch (Exception exception) {
            throw new CustomNotSavedException("User could not be saved with username: " + user.getUsername());
        }
    }

    @Override
    public User update(User user) {
        try {
            return this.userRepository.save(user);
        } catch (Exception exception) {
            throw new CustomNotFoundException("User could not be found with id: " + user.getId());
        }
    }

    @Override
    public void delete(long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception exception) {
            throw new CustomNotFoundException("User could not be deleted with id: " + id);
        }
    }

    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new CustomNotFoundException("User not be found with username: " + username));
        return new MyUserDetails(user);
    }
}
