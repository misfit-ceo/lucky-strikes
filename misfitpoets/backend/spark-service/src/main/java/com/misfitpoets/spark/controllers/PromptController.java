package com.misfitpoets.spark.controllers;

import com.misfitpoets.spark.dto.SparkRequest;
import com.misfitpoets.spark.dto.SparkResponse;
import com.misfitpoets.spark.services.SparkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spark")
public class PromptController {

    private final SparkService sparkService;

    public PromptController(SparkService sparkService) {
        this.sparkService = sparkService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "spark-service is up!";
    }

    @PostMapping("/generate")
    public ResponseEntity<SparkResponse> generatePrompt(@RequestBody SparkRequest request) {
        SparkResponse response = sparkService.generatePrompt(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/prompts")
    public ResponseEntity<List<SparkResponse>> listPrompts() {
        return ResponseEntity.ok(sparkService.listPrompts());
    }

    @GetMapping("/prompts/{id}")
    public ResponseEntity<SparkResponse> getPrompt(@PathVariable Long id) {
        SparkResponse resp = sparkService.getPrompt(id);
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("/prompts/{id}")
    public ResponseEntity<Void> deletePrompt(@PathVariable Long id) {
        sparkService.deletePrompt(id);
        return ResponseEntity.noContent().build();
    }
}
