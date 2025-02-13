package dev.richardktran.quiz_session_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.richardktran.quiz_session_service.entity.QuizSession;

public interface QuizSessionRepository extends MongoRepository<QuizSession, String> {
    
}
