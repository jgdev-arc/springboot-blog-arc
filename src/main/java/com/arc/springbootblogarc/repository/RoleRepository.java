package com.arc.springbootblogarc.repository;

import com.arc.springbootblogarc.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
