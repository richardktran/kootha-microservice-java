package dev.richardktran.quiz_session_service.client;

import org.springframework.web.service.annotation.GetExchange;

import dev.richardktran.quiz_session_service.dto.response.IdGenerationResponse;

public interface IdGenerationClient {
    @GetExchange("/api/v1/id-generation")
    IdGenerationResponse generateId();
}
