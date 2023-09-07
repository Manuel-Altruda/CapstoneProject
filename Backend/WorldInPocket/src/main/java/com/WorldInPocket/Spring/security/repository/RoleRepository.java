package com.WorldInPocket.Spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WorldInPocket.Spring.security.entity.ERole;
import com.WorldInPocket.Spring.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
