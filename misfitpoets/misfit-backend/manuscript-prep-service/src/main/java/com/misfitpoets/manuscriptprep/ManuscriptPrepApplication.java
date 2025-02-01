package com.misfitpoets.manuscriptprep.controllers;

import com.misfitpoets.manuscriptprep.dto.PrepRequest;
import com.misfitpoets.manuscriptprep.dto.PrepResponse;
import com.misfitpoets.manuscriptprep.services.PrepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prep")
public class PrepController {

    private final PrepService prepService;

    public PrepController(PrepService prepService) {
        this.prepService = prepService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "manuscript-prep-service is up!";
    }

    // 1) Submit a doc for advanced formatting, editing, or style checking
    @PostMapping("/submit")
    public ResponseEntity<PrepResponse> submitForPrep(@RequestBody PrepRequest request) {
        PrepResponse response = prepService.submitTask(request);
        return ResponseEntity.ok(response);
    }

    // 2) List all tasks
    @GetMapping("/tasks")
    public ResponseEntity<List<PrepResponse>> listTasks() {
        return ResponseEntity.ok(prepService.listTasks());
    }

    // 3) Get single prep task
    @GetMapping("/tasks/{id}")
    public ResponseEntity<PrepResponse> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(prepService.getTask(id));
    }

    // 4) Mark a task completed or run final conversion
    @PostMapping("/tasks/{id}/complete")
    public ResponseEntity<PrepResponse> completeTask(@PathVariable Long id) {
        return ResponseEntity.ok(prepService.completeTask(id));
    }

    // 5) Delete a task
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        prepService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
