package com.nitor.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nitor.demo.dto.ApiResponse;
import com.nitor.demo.dto.UsersDTO;
import com.nitor.demo.security.AuthRequest;
import com.nitor.demo.security.JwtAuthenticationService;
import com.nitor.demo.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtAuthenticationService jwtService;
    private final UserDetailsService userDetailsService;
    private final AuthService authService;

    public AuthController(AuthenticationManager authenticationManager,
            JwtAuthenticationService jwtService,
            UserDetailsService userDetailsService,
            AuthService authService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody AuthRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.userName(),
                        request.password()));

        UserDetails user = userDetailsService.loadUserByUsername(request.userName());

        String token = jwtService.generateToken(user);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse("SUCCESS", token));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody @Valid UsersDTO request) {
        authService.registerNewUser(request);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse("SUCCESS", "User Created Successfully."));
    }
}