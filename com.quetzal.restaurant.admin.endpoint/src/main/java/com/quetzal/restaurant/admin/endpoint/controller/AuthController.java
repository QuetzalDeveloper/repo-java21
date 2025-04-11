/**
 * Classname: AuthController.java
 * Author: Diego Hernandez Cote
 * Date: 4 abr 2025
 * quetzal developer
 */
package com.quetzal.restaurant.admin.endpoint.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.quetzal.restaurant.admin.endpoint.dto.request.AuthRequest;
import com.quetzal.restaurant.admin.endpoint.dto.response.AuthResponse;
import com.quetzal.restaurant.admin.endpoint.service.JwtService;
import com.quetzal.restaurant.admin.endpoint.service.UserService;

@RestController
@RequestMapping("/restaurant/auth") 
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userDetailsService;
    private final JwtService jwtService;

    public AuthController(AuthenticationManager authenticationManager, UserService userDetailsService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            if (authentication.isAuthenticated()) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
                String token = jwtService.generateToken(userDetails);
                return ResponseEntity.ok(new AuthResponse(token));
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}