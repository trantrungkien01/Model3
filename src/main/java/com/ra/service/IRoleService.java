package com.ra.service;

import com.ra.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleService  extends JpaRepository<Role,Long> {
    Role findByName (String roleName);
}
