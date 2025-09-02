//package org.example.rstech.security;
//
//import org.example.rstech.model.UserEntity;
//import org.example.rstech.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.*;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class UserDetailsServiceImpl implements UserDetailsService {
//    private final UserRepository users;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserEntity u = users.findByUsername(username).orElseThrow(() -> new
//                UsernameNotFoundException("User not found"));
//        return User.withUsername(u.getUsername())
//                .password(u.getPassword())
//                .roles(u.getRole().name())
//                .build();
//    }
//}
//
