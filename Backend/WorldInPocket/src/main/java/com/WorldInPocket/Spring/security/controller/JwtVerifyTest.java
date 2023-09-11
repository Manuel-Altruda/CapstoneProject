package com.WorldInPocket.Spring.security.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class JwtVerifyTest {

	 public static void main(String[] args) {
	        String secretKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9eyJzdWIiOiIxMjM0NWFzZGFkTWFud";
	        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNYW51ZWwiLCJhdXRob3JpdGllcyI6IlJPTEVfQURNSU4ifQ.DmJElFDH4uYLV7FlCSzdN8mJusvavGF2HmMffiXbd2Y";

	        Jws<Claims> claims = Jwts.parserBuilder()
	                .setSigningKey(secretKey)
	                .build()
	                .parseClaimsJws(token);

	        String username = claims.getBody().getSubject();
	        String authorities = claims.getBody().get("authorities", String.class);

	        System.out.println("Username: " + username);
	        System.out.println("Authorities: " + authorities);
	    }

}
