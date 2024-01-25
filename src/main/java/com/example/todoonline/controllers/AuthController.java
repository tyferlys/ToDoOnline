package com.example.todoonline.controllers;

import com.example.todoonline.models.User;
import com.example.todoonline.requests.AuthRequest;
import com.example.todoonline.responses.AuthResponse;
import com.example.todoonline.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registration")
    public ResponseEntity<User> createUser(@RequestBody User user){
        return ResponseEntity.ok().body(authService.createUser(user));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authUser(@RequestBody AuthRequest authRequest){
        String authCode = authService.checkAuth(authRequest);
        return ResponseEntity.ok().body(new AuthResponse(authCode));
    }
}
