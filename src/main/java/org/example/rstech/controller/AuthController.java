//package org.example.rstech.controller;
//
//import org.example.rstech.dto.AuthDto.*;
//import org.example.rstech.security.JwtService;
//import org.example.rstech.model.UserEntity;
//import org.example.rstech.repository.UserRepository;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.*;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/auth")
//@RequiredArgsConstructor
//public class AuthController {
//    private final AuthenticationManager authManager;
//    private final JwtService jwt;
//    private final UserRepository users;
//
//    @PostMapping("/login")
//    @ResponseStatus(HttpStatus.OK)
//    public TokenResponse login(@Valid @RequestBody LoginRequest req) {
//        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
//        UserEntity u = users.findByUsername(req.getUsername()).orElseThrow();
//        String token = jwt.generateToken(u.getUsername(),
//                u.getRole().name());
//        return new TokenResponse(token);
//    }
//}
//
