package com.misfitpoets.coverdesign.util;

import com.misfitpoets.coverdesign.domain.CoverTask;
import com.misfitpoets.coverdesign.dto.CoverRequest;
import com.misfitpoets.coverdesign.dto.CoverResponse;
import org.springframework.stereotype.Component;

@Component
public class CoverMapper {

    public CoverTask toEntity(CoverRequest req) {
        CoverTask task = new CoverTask();
        task.setBookTitle(req.getBookTitle());
        task.setStyleDescription(req.getStyleDescription());
        task.setAuthorId(req.getAuthorId());
        return task;
    }

    public CoverResponse toResponse(CoverTask task) {
        CoverResponse resp = new CoverResponse();
        resp.setId(task.getId());
        resp.setBookTitle(task.getBookTitle());
        resp.setAuthorId(task.getAuthorId());
        resp.setStyleDescription(task.getStyleDescription());
        resp.setStatus(task.getStatus());
        resp.setCoverUrl(task.getCoverUrl());
        return resp;
    }
}
