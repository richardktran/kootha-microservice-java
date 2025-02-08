package dev.richardktran.id_generation_service.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.richardktran.id_generation_service.model.IDGenerator;

@Service
public class GenerationService {
    public IDGenerator generateId() {
        return new IDGenerator(UUID.randomUUID().toString());
    }
}
