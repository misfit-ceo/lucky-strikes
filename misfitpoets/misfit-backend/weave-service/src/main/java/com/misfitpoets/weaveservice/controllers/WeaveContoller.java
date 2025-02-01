package com.misfitpoets.weave.controllers;

import com.misfitpoets.weave.dto.NodeRequest;
import com.misfitpoets.weave.dto.NodeResponse;
import com.misfitpoets.weave.services.WeaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weave")
public class WebController {

    private final WeaveService weaveService;

    public WebController(WeaveService weaveService) {
        this.weaveService = weaveService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "weave-service is up!";
    }

    @PostMapping("/nodes")
    public ResponseEntity<NodeResponse> createNode(@RequestBody NodeRequest request) {
        return ResponseEntity.ok(weaveService.createNode(request));
    }

    @GetMapping("/nodes")
    public ResponseEntity<List<NodeResponse>> listNodes() {
        return ResponseEntity.ok(weaveService.listNodes());
    }

    @GetMapping("/nodes/{id}")
    public ResponseEntity<NodeResponse> getNode(@PathVariable Long id) {
        return ResponseEntity.ok(weaveService.getNode(id));
    }

    @PutMapping("/nodes/{id}")
    public ResponseEntity<NodeResponse> updateNode(@PathVariable Long id, @RequestBody NodeRequest request) {
        return ResponseEntity.ok(weaveService.updateNode(id, request));
    }

    @DeleteMapping("/nodes/{id}")
    public ResponseEntity<Void> deleteNode(@PathVariable Long id) {
        weaveService.deleteNode(id);
        return ResponseEntity.noContent().build();
    }

    // Optional endpoints for linking nodes
    @PostMapping("/links/{sourceId}/{targetId}")
    public ResponseEntity<Void> linkNodes(@PathVariable Long sourceId, @PathVariable Long targetId) {
        weaveService.linkNodes(sourceId, targetId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/links/{sourceId}/{targetId}")
    public ResponseEntity<Void> unlinkNodes(@PathVariable Long sourceId, @PathVariable Long targetId) {
        weaveService.unlinkNodes(sourceId, targetId);
        return ResponseEntity.noContent().build();
    }
}
