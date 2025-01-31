package com.misfitpoets.coverdesign.controllers;

import com.misfitpoets.coverdesign.dto.CoverRequest;
import com.misfitpoets.coverdesign.dto.CoverResponse;
import com.misfitpoets.coverdesign.services.CoverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/covers")
public class CoverController {

    private final CoverService coverService;

    public CoverController(CoverService coverService) {
        this.coverService = coverService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "cover-design-service is up!";
    }

    // 1) Request a new cover design
    @PostMapping("/request")
    public ResponseEntity<CoverResponse> requestCover(@RequestBody CoverRequest request) {
        CoverResponse response = coverService.requestCover(request);
        return ResponseEntity.ok(response);
    }

    // 2) List all cover tasks
    @GetMapping("/tasks")
    public ResponseEntity<List<CoverResponse>> listCovers() {
        return ResponseEntity.ok(coverService.listCovers());
    }

    // 3) Get single cover task
    @GetMapping("/tasks/{id}")
    public ResponseEntity<CoverResponse> getCover(@PathVariable Long id) {
        return ResponseEntity.ok(coverService.getCover(id));
    }

    // 4) Mark a cover as completed (maybe the AI or user finalizes)
    @PostMapping("/tasks/{id}/finalize")
    public ResponseEntity<CoverResponse> finalizeCover(@PathVariable Long id) {
        return ResponseEntity.ok(coverService.finalizeCover(id));
    }

    // 5) Delete a cover task
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteCoverTask(@PathVariable Long id) {
        coverService.deleteCover(id);
        return ResponseEntity.noContent().build();
    }
}
