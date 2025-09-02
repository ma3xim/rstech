//package org.example.rstech.security;
//
//import io.jsonwebtoken.Claims;
//import jakarta.servlet.*;
//import jakarta.servlet.http.*;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class JwtAuthFilter extends OncePerRequestFilter {
//    private final JwtService jwt;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
//            throws ServletException, IOException {
//        String header = req.getHeader("Authorization");
//        if (header != null && header.startsWith("Bearer ")) {
//            String token = header.substring(7);
//            try {
//                Claims claims = jwt.parse(token).getBody();
//                String username = claims.getSubject();
//                String role = claims.get("role", String.class);
//                var auth = new UsernamePasswordAuthenticationToken(username,
//                        null, List.of(new SimpleGrantedAuthority("ROLE_" + role)));
//                SecurityContextHolder.getContext().setAuthentication(auth);
//            } catch (Exception ignored) {}
//        }
//        chain.doFilter(req, res);
//    }
//}
//
