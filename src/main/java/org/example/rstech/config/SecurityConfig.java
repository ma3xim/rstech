//package org.example.rstech.config;
//
//import org.example.rstech.security.JwtAuthFilter;
//import org.example.rstech.security.UserDetailsServiceImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.*;
//import org.springframework.security.authentication.*;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableMethodSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//    private final JwtAuthFilter jwtFilter;
//    private final UserDetailsServiceImpl uds;
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    AuthenticationManager
//    authenticationManager(AuthenticationConfiguration cfg) throws Exception {
//        return cfg.getAuthenticationManager();
//    }
//
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
////        http
////                .csrf(csrf -> csrf.disable())
////                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers(
////                                "/swagger-ui/**",
////                                "/swagger-ui.html",
////                                "/v3/api-docs/**",
////                                "/v3/api-docs.yaml",
////                                "/webjars/**"
////                        ).permitAll().anyRequest().authenticated())
////                .userDetailsService(uds)
////                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().permitAll()
//                );
//        return http.build();
//    }
//}
