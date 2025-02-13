package dev.richardktran.quiz_session_service.service.iml;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import dev.richardktran.quiz_session_service.client.IdGenerationClient;
import dev.richardktran.quiz_session_service.dto.request.CreateSessionRequest;
import dev.richardktran.quiz_session_service.dto.response.CreateSessionResponse;
import dev.richardktran.quiz_session_service.dto.response.IdGenerationResponse;
import dev.richardktran.quiz_session_service.entity.QuizSession;
import dev.richardktran.quiz_session_service.repository.QuizSessionRepository;
import dev.richardktran.quiz_session_service.service.QuizSessionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class QuizSessionServiceIml implements QuizSessionService {
    private final QuizSessionRepository quizSessionRepository;
    private final IdGenerationClient idGenerationClient;


    @Override
    public CreateSessionResponse createQuizSession(CreateSessionRequest request) {
        List<String> participants = new ArrayList<>();
        participants.add(request.getCreatorId());
        
        IdGenerationResponse idResponse = idGenerationClient.generateId();

        String id = idResponse.getId();
        
        QuizSession quizSession = QuizSession.builder()
                .id(id)
                .name(request.getName())
                .description(request.getDescription())
                .creatorId(request.getCreatorId())
                .participants(participants)
                .createdAt(LocalDateTime.now().toString())
                .updatedAt(LocalDateTime.now().toString())
                .build();


        quizSessionRepository.save(quizSession);
        log.info("Quiz session created: {}", quizSession);

        CreateSessionResponse response = new CreateSessionResponse();
        BeanUtils.copyProperties(quizSession, response);

        return response;
    }
    
}
