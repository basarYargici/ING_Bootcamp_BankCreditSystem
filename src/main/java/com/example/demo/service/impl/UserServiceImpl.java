package com.example.demo.service.impl;

import com.example.demo.dtos.UserRegisterDto;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Emirhan Doğandemir at 29.09.2021
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;

    private final RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public UserServiceImpl(UserRepository userRepository,RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService=roleService;
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

        User nUser = user.getUserFromDto();

        nUser.setPassword(bcryptEncoder.encode(user.getPassword()));

        Role role = roleService.findRoleByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        if(nUser.getEmail().split("@")[1].equals("admin.edu")) {
            role = roleService.findRoleByName("ADMIN");
            roleSet.add(role);
        }
        nUser.setRoles(roleSet);
      return  this.userRepository.save(nUser);


    }

    @Override
    public User update(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        this.userRepository.deleteById(id);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }
}
