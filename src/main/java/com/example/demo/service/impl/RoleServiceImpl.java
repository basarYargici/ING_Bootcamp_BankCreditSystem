package com.example.demo.service.impl;

import com.example.demo.exception.CustomNotFoundException;
import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * Created by İbrahim Başar Yargıcı and Emirhan Doğandemir at 29.09.2021
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findRoleByName(name)
                .orElseThrow(() -> new CustomNotFoundException("Role could not be found by name: " + name));
    }
}
