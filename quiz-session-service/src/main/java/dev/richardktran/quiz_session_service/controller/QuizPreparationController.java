package dev.richardktran.quiz_session_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.richardktran.quiz_session_service.dto.request.CreateSessionRequest;
import dev.richardktran.quiz_session_service.dto.response.CreateSessionResponse;
import dev.richardktran.quiz_session_service.service.QuizSessionService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/quiz-preparation")
@AllArgsConstructor
public class QuizPreparationController {

    private final QuizSessionService quizSessionService;
    @PostMapping
    public ResponseEntity<CreateSessionResponse> createQuizSession(@RequestBody CreateSessionRequest request) {
        return ResponseEntity.ok(quizSessionService.createQuizSession(request));
    }
}
