// AgentRepository.java
// Location: misfitpoets/misfitpoets-backend/agent-match-service/src/main/java/com/misfitpoets/agentmatchservice/repositories/AgentRepository.java
package com.misfitpoets.agentmatchservice.repositories;

import com.misfitpoets.agentmatchservice.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, String> {
    // Custom query methods can be added here if needed
}
