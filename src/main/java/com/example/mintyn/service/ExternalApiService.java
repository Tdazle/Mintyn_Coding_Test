package com.example.mintyn.service;

import com.example.mintyn.model.Card;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ExternalApiService {
    private final WebClient webClient;

    public ExternalApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://lookup.binlist.net").build();
    }

    // Method to retrieve card information by bin
    public Card getCardInfoByBin(String bin) {
        return webClient
                .get()
                .uri("/" + bin)  // Appending the bin to the base URL
                .retrieve()
                .bodyToMono(Card.class)
                .block();
    }
}