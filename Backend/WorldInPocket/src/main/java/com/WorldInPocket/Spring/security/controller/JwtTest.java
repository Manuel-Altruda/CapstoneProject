package com.WorldInPocket.Spring.security.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTest {
	public static void main(String[] args) {
        String secretKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9eyJzdWIiOiIxMjM0NWFzZGFkTWFud";
        String username = "Manuel";
        String authorities = "ROLE_ADMIN";

        String token = Jwts.builder()
                .setSubject(username)
                .claim("authorities", authorities)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        System.out.println("Generated Token: " + token);
    }
}
