package com.example.demo.repository;

import com.example.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Emirhan Doğandemir at 29.09.2021
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findRoleByName(String name);
}
