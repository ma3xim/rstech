//package org.example.rstech.security;
//
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.security.Key;
//import java.util.*;
//
//@Service
//public class JwtService {
//    private final Key key;
//    private final long expirationMs;
//
//    public JwtService(@Value("${jwt.secret}") String secret, @Value("${jwt.expiration:3600000}") long expirationMs) {
//        this.key = Keys.hmacShaKeyFor(secret.getBytes());
//        this.expirationMs = expirationMs;
//    }
//
//    public String generateToken(String username, String role) {
//        Date now = new Date();
//        Date exp = new Date(now.getTime() + expirationMs);
//        return Jwts.builder()
//                .setSubject(username)
//                .claim("role", role)
//                .setIssuedAt(now)
//                .setExpiration(exp)
//                .signWith(key, SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public Jws<Claims> parse(String token) {
//        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
//    }
//}
//
