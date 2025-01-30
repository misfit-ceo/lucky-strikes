package com.misfitpoets.agentmatch.controllers;

import com.misfitpoets.agentmatch.dto.AgentProfileRequest;
import com.misfitpoets.agentmatch.dto.AgentProfileResponse;
import com.misfitpoets.agentmatch.dto.MatchRequest;
import com.misfitpoets.agentmatch.services.AgentMatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agent-match")
public class AgentController {

    private final AgentMatchService agentMatchService;

    public AgentController(AgentMatchService agentMatchService) {
        this.agentMatchService = agentMatchService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "agent-match-service is up!";
    }

    @PostMapping("/profiles")
    public ResponseEntity<AgentProfileResponse> createProfile(@RequestBody AgentProfileRequest request) {
        AgentProfileResponse saved = agentMatchService.createProfile(request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/profiles")
    public ResponseEntity<List<AgentProfileResponse>> listProfiles() {
        List<AgentProfileResponse> all = agentMatchService.listProfiles();
        return ResponseEntity.ok(all);
    }

    @PostMapping("/match")
    public ResponseEntity<List<AgentProfileResponse>> matchAgents(@RequestBody MatchRequest matchReq) {
        List<AgentProfileResponse> matched = agentMatchService.matchAgents(matchReq);
        return ResponseEntity.ok(matched);
    }
}
