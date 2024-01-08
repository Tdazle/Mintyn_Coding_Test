package com.example.mintyn.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Token {
    @JsonProperty("token")
    private String token;

    public Token(String token) {
        this.token = token;
    }
}