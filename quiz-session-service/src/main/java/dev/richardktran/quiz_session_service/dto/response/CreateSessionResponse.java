package dev.richardktran.quiz_session_service.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CreateSessionResponse {
    private String id;
    private String name;
    private String description;

    private List<String> participants;
    private String creatorId;

    private String createdAt;
    private String updatedAt;
}
