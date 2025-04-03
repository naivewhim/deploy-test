package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BServiceController {

    @GetMapping("/")
    public String hello() {
        return "I am Service B";
    }
}
