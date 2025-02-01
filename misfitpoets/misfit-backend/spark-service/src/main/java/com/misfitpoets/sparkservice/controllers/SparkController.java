// SparkController.java
// Location: misfitpoets/misfitpoets-backend/spark-service/src/main/java/com/misfitpoets/sparkservice/controllers/SparkController.java
package com.misfitpoets.sparkservice.controllers;

import com.misfitpoets.sparkservice.models.Prompt;
import com.misfitpoets.sparkservice.services.SparkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spark")
public class SparkController {

    private final SparkService sparkService;

    public SparkController(SparkService sparkService) {
        this.sparkService = sparkService;
    }

    /**
     * POST /api/spark/generate
     * Generate a new writing prompt based on theme and tone.
     *
     * @param request A JSON object containing "theme" and "tone".
     * @return The generated Prompt.
     */
    @PostMapping("/generate")
    public Prompt generatePrompt(@RequestBody PromptRequest request) {
        return sparkService.generatePrompt(request.getTheme(), request.getTone());
    }

    /**
     * GET /api/spark/prompts
     * Retrieve all generated prompts.
     *
     * @return List of Prompt objects.
     */
    @GetMapping("/prompts")
    public List<Prompt> getAllPrompts() {
        return sparkService.getAllPrompts();
    }

    /**
     * GET /api/spark/prompts/{id}
     * Retrieve a specific prompt by ID.
     *
     * @param id The prompt ID.
     * @return The Prompt object if found.
     */
    @GetMapping("/prompts/{id}")
    public Prompt getPromptById(@PathVariable Long id) {
        return sparkService.getPromptById(id)
                .orElseThrow(() -> new RuntimeException("Prompt not found with id " + id));
    }

    /**
     * DELETE /api/spark/prompts/{id}
     * Delete a specific prompt by ID.
     *
     * @param id The prompt ID.
     */
    @DeleteMapping("/prompts/{id}")
    public void deletePrompt(@PathVariable Long id) {
        sparkService.deletePrompt(id);
    }
    
    // Request DTO for generating a prompt
    public static class PromptRequest {
        private String theme;
        private String tone;

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }

        public String getTone() {
            return tone;
        }

        public void setTone(String tone) {
            this.tone = tone;
        }
    }
}
