package com.misfitpoets.scrappyscraps.util;

import com.misfitpoets.scrappyscraps.domain.ScrapEntry;
import com.misfitpoets.scrappyscraps.dto.ScrapRequest;
import com.misfitpoets.scrappyscraps.dto.ScrapResponse;
import org.springframework.stereotype.Component;

@Component
public class ScrappyMapper {

    public ScrapEntry toEntity(ScrapRequest req) {
        ScrapEntry e = new ScrapEntry();
        e.setTitle(req.getTitle());
        e.setSummary(req.getSummary());
        e.setSourceUrl(req.getSourceUrl());
        e.setCategory(req.getCategory());
        e.setExternalId(req.getExternalId());
        return e;
    }

    public ScrapResponse toResponse(ScrapEntry e) {
        ScrapResponse resp = new ScrapResponse();
        resp.setId(e.getId());
        resp.setTitle(e.getTitle());
        resp.setSummary(e.getSummary());
        resp.setSourceUrl(e.getSourceUrl());
        resp.setCategory(e.getCategory());
        resp.setExternalId(e.getExternalId());
        return resp;
    }
}
