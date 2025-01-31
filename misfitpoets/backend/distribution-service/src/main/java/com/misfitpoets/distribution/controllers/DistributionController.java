package com.misfitpoets.distribution.controllers;

import com.misfitpoets.distribution.dto.DistRequest;
import com.misfitpoets.distribution.dto.DistResponse;
import com.misfitpoets.distribution.services.DistributionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/distribution")
public class DistributionController {

    private final DistributionService distService;

    public DistributionController(DistributionService distService) {
        this.distService = distService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "distribution-service is up!";
    }

    // 1) Request distribution to a specific channel
    @PostMapping("/request")
    public ResponseEntity<DistResponse> requestDistribution(@RequestBody DistRequest request) {
        DistResponse response = distService.requestDistribution(request);
        return ResponseEntity.ok(response);
    }

    // 2) List tasks
    @GetMapping("/tasks")
    public ResponseEntity<List<DistResponse>> listTasks() {
        return ResponseEntity.ok(distService.listTasks());
    }

    // 3) Get single distribution task
    @GetMapping("/tasks/{id}")
    public ResponseEntity<DistResponse> getDistTask(@PathVariable Long id) {
        return ResponseEntity.ok(distService.getTask(id));
    }

    // 4) Start actual distribution
    @PostMapping("/tasks/{id}/start")
    public ResponseEntity<DistResponse> startDistribution(@PathVariable Long id) {
        return ResponseEntity.ok(distService.startDistribution(id));
    }

    // 5) Delete a distribution task
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteDistTask(@PathVariable Long id) {
        distService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
