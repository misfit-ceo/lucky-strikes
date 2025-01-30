package com.misfitpoets.agentmatch.services;

import com.misfitpoets.agentmatch.domain.AgentProfile;
import com.misfitpoets.agentmatch.domain.enums.Specialization;
import com.misfitpoets.agentmatch.dto.AgentProfileRequest;
import com.misfitpoets.agentmatch.dto.AgentProfileResponse;
import com.misfitpoets.agentmatch.dto.MatchRequest;
import com.misfitpoets.agentmatch.exceptions.AgentNotFoundException;
import com.misfitpoets.agentmatch.repositories.AgentProfileRepository;
import com.misfitpoets.agentmatch.util.AgentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentMatchService {

    private final AgentProfileRepository agentRepo;
    private final AgentMapper agentMapper;

    public AgentMatchService(AgentProfileRepository agentRepo, AgentMapper agentMapper) {
        this.agentRepo = agentRepo;
        this.agentMapper = agentMapper;
    }

    public AgentProfileResponse createProfile(AgentProfileRequest req) {
        AgentProfile profile = agentMapper.toEntity(req);
        profile = agentRepo.save(profile);
        return agentMapper.toResponse(profile);
    }

    public List<AgentProfileResponse> listProfiles() {
        return agentRepo.findAll().stream()
                .map(agentMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<AgentProfileResponse> matchAgents(MatchRequest matchReq) {
        // Convert user input to enum or default to OTHER
        Specialization sp;
        try {
            sp = Specialization.valueOf(matchReq.getManuscriptGenre().toUpperCase());
        } catch(Exception e) {
            sp = Specialization.OTHER;
        }
        // Filter by specialization and minExperience
        List<AgentProfile> filtered = agentRepo.findAll().stream()
            .filter(agent -> agent.getSpecialization() == sp || sp == Specialization.OTHER)
            .filter(agent -> agent.getYearsOfExperience() >= matchReq.getMinExperience())
            .collect(Collectors.toList());

        return filtered.stream()
                .map(agentMapper::toResponse)
                .collect(Collectors.toList());
    }

    // Example of a single get method:
    public AgentProfileResponse getAgent(Long id) {
        AgentProfile found = agentRepo.findById(id)
                .orElseThrow(() -> new AgentNotFoundException("Agent not found with id: " + id));
        return agentMapper.toResponse(found);
    }
}
