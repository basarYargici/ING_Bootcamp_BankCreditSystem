package com.example.demo.service.impl;

import com.example.demo.config.MyUserDetails;
import com.example.demo.config.PasswordConfig;
import com.example.demo.dtos.UserRegisterDto;
import com.example.demo.dtos.converter.UserRegisterDtoConverter;
import com.example.demo.exception.CustomNotFoundException;
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
    public User findUserById(int id) {
        return this.userRepository.getById(id);
    }

    @Override
    public User save(UserRegisterDto user) {

        User newUser = userRegisterDtoConverter.userFromDto(user);

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
    }

    @Override
    public User update(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        this.userRepository.deleteById(id);
    }

    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new CustomNotFoundException("User not be found with username: " + username));
        return new MyUserDetails(user);
    }
}
