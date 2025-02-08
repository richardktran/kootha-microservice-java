package dev.richardktran.id_generation_service.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.richardktran.id_generation_service.model.IDGenerator;
import dev.richardktran.id_generation_service.service.GenerationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/id-generation")
@RequiredArgsConstructor
public class GenerationController {
    private final GenerationService generationService;

    @GetMapping
    public ResponseEntity<IDGenerator> generateId() {
        IDGenerator result = generationService.generateId();
        return ResponseEntity.ok(result);
    }
}
