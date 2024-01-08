package com.example.mintyn.model;

import com.example.mintyn.deserializer.BankInfoDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Card {
    @JsonProperty("scheme")
    private String scheme;

    @JsonProperty("type")
    private String type;

    @JsonProperty("bank")
    @JsonDeserialize(using = BankInfoDeserializer.class)
    private String bank;

}