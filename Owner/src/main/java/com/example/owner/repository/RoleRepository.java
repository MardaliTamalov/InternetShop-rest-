package com.example.owner.repository;

import com.example.owner.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Integer>{

    Set<Role> getRolesById(Integer id);
}
