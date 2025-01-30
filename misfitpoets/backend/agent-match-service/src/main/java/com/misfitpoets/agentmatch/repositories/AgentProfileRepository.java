package com.misfitpoets.agentmatch.repositories;

import com.misfitpoets.agentmatch.domain.AgentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentProfileRepository extends JpaRepository<AgentProfile, Long> {
    // Additional query methods as needed
}
