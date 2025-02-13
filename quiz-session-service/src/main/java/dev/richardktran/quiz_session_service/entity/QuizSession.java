package dev.richardktran.quiz_session_service.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(value = "quiz_sessions")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class QuizSession {
    @Id
    private String id;
    private String name;
    private String description;

    private String creatorId;
    private List<String> participants;

    private String createdAt;
    private String updatedAt;
}
