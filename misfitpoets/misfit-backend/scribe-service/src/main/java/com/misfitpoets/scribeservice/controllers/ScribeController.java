// ScribeController.java
// Location: misfitpoets/misfitpoets-backend/scribe-service/src/main/java/com/misfitpoets/scribeservice/controllers/ScribeController.java
package com.misfitpoets.scribeservice.controllers;

import com.misfitpoets.scribeservice.models.Manuscript;
import com.misfitpoets.scribeservice.services.ScribeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scribe")
public class ScribeController {

    private final ScribeService scribeService;

    public ScribeController(ScribeService scribeService) {
        this.scribeService = scribeService;
    }

    /**
     * POST /api/scribe/edit
     * Edits and enhances the provided manuscript text.
     *
     * @param manuscript The manuscript object containing raw text.
     * @return The enhanced manuscript.
     */
    @PostMapping("/edit")
    public Manuscript editManuscript(@RequestBody Manuscript manuscript) {
        return scribeService.editManuscript(manuscript);
    }

    /**
     * GET /api/scribe/health
     * Health check endpoint.
     *
     * @return A simple health message.
     */
    @GetMapping("/health")
    public String healthCheck() {
        return "Scribe Service is running.";
    }
}
