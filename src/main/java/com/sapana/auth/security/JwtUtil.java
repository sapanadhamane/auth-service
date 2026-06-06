package com.sapana.auth.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private static final String SECRET_KEY="mySecreteKeyForJwtAuthentication123456";

    public String generateToken(String email){
        return Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis()+1000*6*60)
    ).signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }
    
}
