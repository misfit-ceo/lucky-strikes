package com.misfitpoets.agentmatch.util;

import com.misfitpoets.agentmatch.domain.AgentProfile;
import com.misfitpoets.agentmatch.domain.enums.Specialization;
import com.misfitpoets.agentmatch.dto.AgentProfileRequest;
import com.misfitpoets.agentmatch.dto.AgentProfileResponse;
import org.springframework.stereotype.Component;

@Component
public class AgentMapper {

    public AgentProfile toEntity(AgentProfileRequest req) {
        AgentProfile entity = new AgentProfile();
        entity.setAgentName(req.getAgentName());
        entity.setEmail(req.getEmail());
        entity.setYearsOfExperience(req.getYearsOfExperience());
        try {
            entity.setSpecialization(Specialization.valueOf(req.getSpecialization().toUpperCase()));
        } catch(Exception e) {
            entity.setSpecialization(Specialization.OTHER);
        }
        return entity;
    }

    public AgentProfileResponse toResponse(AgentProfile profile) {
        AgentProfileResponse resp = new AgentProfileResponse();
        resp.setId(profile.getId());
        resp.setAgentName(profile.getAgentName());
        resp.setEmail(profile.getEmail());
        resp.setYearsOfExperience(profile.getYearsOfExperience());
        resp.setSpecialization(profile.getSpecialization().name());
        return resp;
    }
}
