package dev.richardktran.quiz_session_service.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateSessionRequest {
    private String name;
    private String description;
    private String creatorId;
}
