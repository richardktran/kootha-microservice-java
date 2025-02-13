package dev.richardktran.quiz_session_service.service;

import dev.richardktran.quiz_session_service.dto.request.CreateSessionRequest;
import dev.richardktran.quiz_session_service.dto.response.CreateSessionResponse;

public interface QuizSessionService {
    CreateSessionResponse createQuizSession(CreateSessionRequest request);
}
