package dev.richardktran.api_gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallbackRoute")
public class FallbackController {
    
    @GetMapping
    public String fallback() {
        return "Service is currently unavailable. Please try again later.";
    }
}
