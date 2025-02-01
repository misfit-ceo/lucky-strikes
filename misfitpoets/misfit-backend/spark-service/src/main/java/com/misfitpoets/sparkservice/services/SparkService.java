// SparkService.java
// Location: misfitpoets/misfitpoets-backend/spark-service/src/main/java/com/misfitpoets/sparkservice/services/SparkService.java
package com.misfitpoets.sparkservice.services;

import com.misfitpoets.sparkservice.models.Prompt;
import com.misfitpoets.sparkservice.repositories.PromptRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SparkService {

    private final PromptRepository promptRepository;

    public SparkService(PromptRepository promptRepository) {
        this.promptRepository = promptRepository;
    }

    /**
     * Simulates generating a new writing prompt based on the provided theme and tone.
     * In production, this might integrate with an AI model.
     *
     * @param theme The theme for the prompt.
     * @param tone  The tone for the prompt.
     * @return The generated Prompt object.
     */
    public Prompt generatePrompt(String theme, String tone) {
        // Simulated prompt generation logic
        String generatedText = "A " + tone + " story set in a world of " + theme + ".";
        Prompt prompt = new Prompt(theme, tone, generatedText);
        return promptRepository.save(prompt);
    }

    /**
     * Retrieves all generated prompts.
     *
     * @return List of prompts.
     */
    public List<Prompt> getAllPrompts() {
        return promptRepository.findAll();
    }

    /**
     * Retrieves a prompt by its ID.
     *
     * @param id The prompt ID.
     * @return Optional containing the prompt if found.
     */
    public Optional<Prompt> getPromptById(Long id) {
        return promptRepository.findById(id);
    }

    /**
     * Deletes a prompt by its ID.
     *
     * @param id The prompt ID.
     */
    public void deletePrompt(Long id) {
        promptRepository.deleteById(id);
    }
}
