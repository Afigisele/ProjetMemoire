package com.projet.workLink.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.projet.workLink.ServicesImpl.TokenBlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final TokenBlacklistService tokenBlacklistService;
    private final UserDetailsService userDetailsService;

    @Autowired
    public JwtAuthenticationFilter(JwtService jwtService, TokenBlacklistService tokenBlacklistService,
                                   UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.tokenBlacklistService = tokenBlacklistService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        final String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        // Extraction du token JWT
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            try {
                username = jwtService.extractUsername(token);
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }

        // Authentification
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (!tokenBlacklistService.isTokenBlacklisted(token)) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);

                if (jwtService.isTokenValid(token, userDetails.getUsername())) {
                    // Extraire les claims depuis le token
                    Claims claims = Jwts.parserBuilder()
                            .setSigningKey(jwtService.getSigningKey())
                            .build()
                            .parseClaimsJws(token)
                            .getBody();

                    List<String> authoritiesFromToken = claims.get("authorities", List.class);

                    // Fusion des autorités UserDetails + token
                    List<GrantedAuthority> authorities = new ArrayList<>(userDetails.getAuthorities());
                    if (authoritiesFromToken != null) {
                        List<GrantedAuthority> tokenAuthorities = authoritiesFromToken.stream()
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toList());
                        for (GrantedAuthority auth : tokenAuthorities) {
                            if (!authorities.contains(auth)) {
                                authorities.add(auth);
                            }
                        }
                    }

                    // Création de l'objet d'authentification
                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                            userDetails, null, authorities);
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
