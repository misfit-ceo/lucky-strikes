// AgentMatchService.java
// Location: misfitpoets/misfitpoets-backend/agent-match-service/src/main/java/com/misfitpoets/agentmatchservice/services/AgentMatchService.java
package com.misfitpoets.agentmatchservice.services;

import com.misfitpoets.agentmatchservice.models.Agent;
import com.misfitpoets.agentmatchservice.repositories.AgentRepository;
import com.misfitpoets.agentmatchservice.controllers.AgentMatchController.Preferences;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentMatchService {
    private final AgentRepository agentRepository;

    public AgentMatchService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public Agent createAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public List<Agent> matchAgents(Preferences preferences) {
        // Implement matching logic based on genre and experience
        // For now, return all agents as a stub
        return agentRepository.findAll();
    }
}
