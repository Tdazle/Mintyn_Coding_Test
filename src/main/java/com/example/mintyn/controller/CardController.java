package com.example.mintyn.controller;

import com.example.mintyn.model.Card;
import com.example.mintyn.model.ApiResponse;
import com.example.mintyn.service.ExternalApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card-scheme")
public class CardController {

    private final ExternalApiService externalApiService;

    @GetMapping("/verify/{bin}")
    public ApiResponse<Card> getCardInfo(@PathVariable String bin) {
        Card card = externalApiService.getCardInfoByBin(bin);
        return new ApiResponse<>(true, card);
    }

}
