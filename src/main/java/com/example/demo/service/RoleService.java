package com.example.demo.service;

import com.example.demo.model.Role;

/**
 * Created by İbrahim Başar Yargıcı and Emirhan Doğandemir at 29.09.2021
 */
public interface RoleService {
    Role findRoleByName(String name);
}
