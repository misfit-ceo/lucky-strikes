package com.misfitpoets.marketing.util;

import com.misfitpoets.marketing.domain.Campaign;
import com.misfitpoets.marketing.dto.CampaignRequest;
import com.misfitpoets.marketing.dto.CampaignResponse;
import org.springframework.stereotype.Component;

@Component
public class CampaignMapper {

    public Campaign toEntity(CampaignRequest req) {
        Campaign camp = new Campaign();
        camp.setCampaignName(req.getCampaignName());
        camp.setAuthorId(req.getAuthorId());
        camp.setMessage(req.getMessage());
        return camp;
    }

    public CampaignResponse toResponse(Campaign camp) {
        CampaignResponse resp = new CampaignResponse();
        resp.setId(camp.getId());
        resp.setCampaignName(camp.getCampaignName());
        resp.setAuthorId(camp.getAuthorId());
        resp.setMessage(camp.getMessage());
        resp.setStatus(camp.getStatus());
        return resp;
    }
}
