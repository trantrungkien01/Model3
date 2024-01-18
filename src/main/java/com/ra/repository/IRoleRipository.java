package com.ra.repository;

import com.ra.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRipository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByName(String roleName);
}
