// AgentMatchController.java
// Location: misfitpoets/misfitpoets-backend/agent-match-service/src/main/java/com/misfitpoets/agentmatchservice/controllers/AgentMatchController.java
package com.misfitpoets.agentmatchservice.controllers;

import com.misfitpoets.agentmatchservice.models.Agent;
import com.misfitpoets.agentmatchservice.services.AgentMatchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agent-match")
public class AgentMatchController {

    private final AgentMatchService agentMatchService;

    public AgentMatchController(AgentMatchService agentMatchService) {
        this.agentMatchService = agentMatchService;
    }

    @PostMapping("/profiles")
    public Agent createAgentProfile(@RequestBody Agent agent) {
        return agentMatchService.createAgent(agent);
    }

    @GetMapping("/profiles")
    public List<Agent> getAgentProfiles() {
        return agentMatchService.getAllAgents();
    }

    @PostMapping("/match")
    public List<Agent> matchAgents(@RequestBody Preferences preferences) {
        return agentMatchService.matchAgents(preferences);
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "Agent Match Service is running.";
    }
    
    // Preferences class can be an inner static class or separate file as needed.
    public static class Preferences {
        public String genre;
        public int experience;
        // getters and setters omitted for brevity
    }
}
