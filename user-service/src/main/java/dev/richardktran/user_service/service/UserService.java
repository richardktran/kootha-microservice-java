package dev.richardktran.user_service.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.richardktran.user_service.dto.CreateUserRequest;
import dev.richardktran.user_service.dto.CreateUserResponse;
import dev.richardktran.user_service.dto.GetUserResponse;
import dev.richardktran.user_service.entity.User;
import dev.richardktran.user_service.exception.NotFoundException;
import dev.richardktran.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public GetUserResponse getUser(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));

        return new GetUserResponse(user.getId(), user.getName());
    }

    public CreateUserResponse createUser(CreateUserRequest userRequest) {
        String id = UUID.randomUUID().toString();
        User user = User.builder().id(id).name(userRequest.getName()).build();

        userRepository.save(user);
        
        return new CreateUserResponse(id, user.getName());
    }
}
