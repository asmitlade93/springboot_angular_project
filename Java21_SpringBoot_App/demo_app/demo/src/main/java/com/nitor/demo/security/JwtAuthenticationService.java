package com.nitor.demo.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.MacAlgorithm;


@Service
public class JwtAuthenticationService {

    private static final String SECRET_KEY = "ksjdgbndfgfdfdsfsfsdfsdfdsfdsfhiurejgeh895475894357324bjksdjkfhbdsfu973e4345435";

    private static final long EXPIRATION_TIME = 1000 * 60 * 30;

    private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    private final MacAlgorithm algo = Jwts.SIG.HS256;

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder().subject(userDetails.getUsername())
            .claim("roles", userDetails.getAuthorities())
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(key, algo)
            .compact();
    }

    public String extractUserName(String token) {
        return extractClaims(token).getSubject();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        return extractUserName(token).equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }


    private Claims extractClaims(String token) {
        return Jwts.parser()
            .verifyWith(key)
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }

    






}
