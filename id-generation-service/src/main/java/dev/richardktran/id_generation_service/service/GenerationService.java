package dev.richardktran.id_generation_service.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.richardktran.id_generation_service.model.IDGenerator;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GenerationService {
    public IDGenerator generateId() {
        log.info("Generating ID");
        return new IDGenerator(UUID.randomUUID().toString());
    }
}
