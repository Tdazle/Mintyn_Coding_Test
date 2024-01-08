package com.example.mintyn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    public LoginResponse(String token) {
        this.token = token;
    }
    private String token;
}