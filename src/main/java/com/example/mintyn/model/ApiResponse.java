package com.example.mintyn.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ApiResponse<T> {
    private boolean success;

    @JsonProperty("payload")
    private T payload;

    public ApiResponse(boolean success, T payload) {
        this.success = success;
        this.payload = payload;
    }
}
