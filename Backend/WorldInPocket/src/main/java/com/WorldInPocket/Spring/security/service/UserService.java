package com.WorldInPocket.Spring.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WorldInPocket.Spring.security.entity.User;
import com.WorldInPocket.Spring.security.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService implements IuserService{
	private List<User> users = new ArrayList<>();
	
	@Autowired
    private UserRepository userRepository;
	
	 
	   public UserService(UserRepository userRepository) {
	       this.userRepository = userRepository;
	       
	   }
	
	public List<User> getAllUtenti() {
        return userRepository.findAll();
    }

    public User getUtenteById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Utente non trovato con ID: " + id));
    }

    public User createUtente(User utente) {
        return userRepository.save(utente);
    }

    public User updateUtente(Long id, User utente) {
    	User existingUtente = getUtenteById(id);
        existingUtente.setUsername(utente.getUsername());
        existingUtente.setName(utente.getName());
        existingUtente.setSurname(utente.getSurname());
        existingUtente.setEmail(utente.getEmail());
        return userRepository.save(existingUtente);
    }

    public void deleteUtente(Long id) {
        userRepository.deleteById(id);
    }
    
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with ID: " + id));
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getUserByEmail(String email) {
        return users.stream()
            .filter(user -> user.getEmail().equals(email))
            .findFirst()
            .orElse(null);
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setName(updatedUser.getName());
        existingUser.setSurname(updatedUser.getSurname());
        existingUser.setEmail(updatedUser.getEmail());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    public User getUserByEmailOrPassword(String username, String password) {
        return users.stream()
            .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
            .findFirst()
            .orElse(null);
    }
}
