package com.example.mintyn.controller;

import com.example.mintyn.dto.LoginRequest;
import com.example.mintyn.dto.SignUpRequest;
import com.example.mintyn.model.ApiResponse;
import com.example.mintyn.model.Token;
import com.example.mintyn.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp2(@RequestBody SignUpRequest signUpRequest) {
        return userService.signUp(signUpRequest);
    }

    @PostMapping("/login")
    public ApiResponse<Token> login(@RequestBody LoginRequest loginRequest, HttpServletResponse response) {
        String username = loginRequest.getUsername();
        userService.loadUserByUsername(username);
        Token token = userService.getToken(username);
        return new ApiResponse<>(true, token);
    }

    // Additional user-related endpoints can be added as needed
}

