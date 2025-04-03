package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class AServiceController {

    private final WebClient webClient;
    private final String bServiceUrl;

    public AServiceController(WebClient.Builder builder,
                              @Value("${b.service.url}") String bServiceUrl) {
        this.webClient = builder.build();
        this.bServiceUrl = bServiceUrl;
    }
    @GetMapping("/")
    public String hello() {
        return "I am Service A";
    }

    @GetMapping("/call-b")
    public String callB() {
        return webClient.get()
                .uri(bServiceUrl)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
