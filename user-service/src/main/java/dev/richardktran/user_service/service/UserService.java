package dev.richardktran.user_service.service;

import org.springframework.stereotype.Service;

import dev.richardktran.user_service.client.IdGenerationClient;
import dev.richardktran.user_service.dto.CreateUserRequest;
import dev.richardktran.user_service.dto.CreateUserResponse;
import dev.richardktran.user_service.dto.GetUserResponse;
import dev.richardktran.user_service.dto.IdGenerationResponse;
import dev.richardktran.user_service.entity.User;
import dev.richardktran.user_service.exception.NotFoundException;
import dev.richardktran.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final IdGenerationClient idGenerationClient;

    public GetUserResponse getUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));

        return new GetUserResponse(user.getId(), user.getName());
    }

    public CreateUserResponse createUser(CreateUserRequest userRequest) {
        IdGenerationResponse idResponse = idGenerationClient.generateId();

        String id = idResponse.getId();

        User user = User.builder().id(id).name(userRequest.getName()).build();

        userRepository.save(user);
        
        return new CreateUserResponse(id, user.getName());
    }
}
