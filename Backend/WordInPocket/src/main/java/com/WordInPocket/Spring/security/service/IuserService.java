package com.WordInPocket.Spring.security.service;

import java.util.List;

import com.WordInPocket.Spring.security.entity.User;

public interface IuserService {
	User createUser(User user);
    User getUserById(Long id);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    User updateUser(Long id, User updatedUser);
    void deleteUser(Long id);
}
