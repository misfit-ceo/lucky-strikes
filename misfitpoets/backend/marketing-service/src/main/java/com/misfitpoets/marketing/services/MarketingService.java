package com.misfitpoets.marketing.services;

import com.misfitpoets.marketing.domain.Campaign;
import com.misfitpoets.marketing.dto.CampaignRequest;
import com.misfitpoets.marketing.dto.CampaignResponse;
import com.misfitpoets.marketing.exceptions.CampaignNotFoundException;
import com.misfitpoets.marketing.repositories.CampaignRepository;
import com.misfitpoets.marketing.util.CampaignMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarketingService {

    private final CampaignRepository repo;
    private final CampaignMapper mapper;
    private final EmailBroadcaster broadcaster; 

    public MarketingService(CampaignRepository repo, CampaignMapper mapper, EmailBroadcaster broadcaster) {
        this.repo = repo;
        this.mapper = mapper;
        this.broadcaster = broadcaster;
    }

    public CampaignResponse createCampaign(CampaignRequest request) {
        Campaign camp = mapper.toEntity(request);
        camp.setStatus("DRAFT");
        camp = repo.save(camp);
        return mapper.toResponse(camp);
    }

    public List<CampaignResponse> listCampaigns() {
        return repo.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public CampaignResponse getCampaign(Long id) {
        Campaign camp = repo.findById(id)
                .orElseThrow(() -> new CampaignNotFoundException("Campaign not found: " + id));
        return mapper.toResponse(camp);
    }

    public CampaignResponse launchCampaign(Long id) {
        Campaign camp = repo.findById(id)
                .orElseThrow(() -> new CampaignNotFoundException("Cannot launch. Not found: " + id));

        // Possibly do something like broadcaster.sendEmails
        broadcaster.broadcast(camp);

        camp.setStatus("LAUNCHED");
        repo.save(camp);
        return mapper.toResponse(camp);
    }

    public void deleteCampaign(Long id) {
        Campaign camp = repo.findById(id)
                .orElseThrow(() -> new CampaignNotFoundException("Cannot delete. Not found: " + id));
        repo.delete(camp);
    }
}
