package com.misfitpoets.flow.controllers;

import com.misfitpoets.flow.dto.TaskRequest;
import com.misfitpoets.flow.dto.TaskResponse;
import com.misfitpoets.flow.services.FlowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flow")
public class TaskController {

    private final FlowService flowService;

    public TaskController(FlowService flowService) {
        this.flowService = flowService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "flow-service is up!";
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskResponse> createTask(@RequestBody TaskRequest req) {
        TaskResponse created = flowService.createTask(req);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskResponse>> listTasks() {
        return ResponseEntity.ok(flowService.listTasks());
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(flowService.getTask(id));
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable Long id, @RequestBody TaskRequest req) {
        TaskResponse updated = flowService.updateTask(id, req);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        flowService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
