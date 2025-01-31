package com.misfitpoets.spark.services;

import com.misfitpoets.spark.domain.SparkPrompt;
import com.misfitpoets.spark.domain.enums.PromptTone;
import com.misfitpoets.spark.dto.SparkRequest;
import com.misfitpoets.spark.dto.SparkResponse;
import com.misfitpoets.spark.exceptions.PromptNotFoundException;
import com.misfitpoets.spark.repositories.SparkPromptRepository;
import com.misfitpoets.spark.util.SparkMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class SparkService {

    private final SparkPromptRepository promptRepo;
    private final SparkMapper mapper;

    public SparkService(SparkPromptRepository promptRepo, SparkMapper mapper) {
        this.promptRepo = promptRepo;
        this.mapper = mapper;
    }

    public SparkResponse generatePrompt(SparkRequest request) {
        // Example logic: combine theme, style, tone, and some random spark
        String generatedText = "Write a " + request.getStyle() + " about " + request.getTheme()
            + ", with a tone of " + request.getTone().toLowerCase()
            + ". [AI placeholders or expansions could go here]";

        SparkPrompt prompt = new SparkPrompt();
        prompt.setTheme(request.getTheme());
        prompt.setStyle(request.getStyle());
        prompt.setPromptText(generatedText);
        try {
            prompt.setTone(PromptTone.valueOf(request.getTone().toUpperCase()));
        } catch (Exception e) {
            prompt.setTone(PromptTone.INTROSPECTIVE); // fallback
        }
        prompt.setOwnerId(request.getOwnerId());

        prompt = promptRepo.save(prompt);
        return mapper.toResponse(prompt);
    }

    public List<SparkResponse> listPrompts() {
        return promptRepo.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public SparkResponse getPrompt(Long id) {
        SparkPrompt found = promptRepo.findById(id)
                .orElseThrow(() -> new PromptNotFoundException("Prompt not found: " + id));
        return mapper.toResponse(found);
    }

    public void deletePrompt(Long id) {
        SparkPrompt found = promptRepo.findById(id)
                .orElseThrow(() -> new PromptNotFoundException("Cannot delete. Prompt not found: " + id));
        promptRepo.delete(found);
    }
}
