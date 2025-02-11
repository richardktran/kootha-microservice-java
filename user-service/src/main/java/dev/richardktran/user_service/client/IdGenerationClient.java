package dev.richardktran.user_service.client;

import org.springframework.web.service.annotation.GetExchange;

import dev.richardktran.user_service.dto.IdGenerationResponse;

public interface IdGenerationClient {
    @GetExchange("/api/v1/id-generation")
    IdGenerationResponse generateId();

}

