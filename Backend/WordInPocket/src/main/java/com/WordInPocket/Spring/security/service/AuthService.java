package com.WordInPocket.Spring.security.service;

import com.WordInPocket.Spring.security.payload.LoginDto;
import com.WordInPocket.Spring.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    
}
