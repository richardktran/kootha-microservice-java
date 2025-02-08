package dev.richardktran.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.richardktran.user_service.entity.User;

public interface UserRepository extends JpaRepository<User,String> {
    
}
