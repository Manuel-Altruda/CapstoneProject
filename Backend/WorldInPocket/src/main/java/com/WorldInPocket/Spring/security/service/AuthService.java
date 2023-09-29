package com.WorldInPocket.Spring.security.service;

import com.WorldInPocket.Spring.security.entity.User;
import com.WorldInPocket.Spring.security.payload.LoginDto;
import com.WorldInPocket.Spring.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
	User getUserByEmailOrUsername(String credential);
    
}
