package com.WorldInPocket.Spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.WorldInPocket.Spring.security.entity.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);
    
    User findById(long id);
    
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    
    User findByUsername(String username);

   
}
