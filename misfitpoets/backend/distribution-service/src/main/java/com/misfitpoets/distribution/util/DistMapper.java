package com.misfitpoets.distribution.util;

import com.misfitpoets.distribution.domain.DistributionTask;
import com.misfitpoets.distribution.dto.DistRequest;
import com.misfitpoets.distribution.dto.DistResponse;
import org.springframework.stereotype.Component;

@Component
public class DistMapper {

    public DistributionTask toEntity(DistRequest req) {
        DistributionTask task = new DistributionTask();
        task.setManuscriptId(req.getManuscriptId());
        task.setCoverId(req.getCoverId());
        task.setDistributionChannel(req.getDistributionChannel());
        return task;
    }

    public DistResponse toResponse(DistributionTask task) {
        DistResponse resp = new DistResponse();
        resp.setId(task.getId());
        resp.setManuscriptId(task.getManuscriptId());
        resp.setCoverId(task.getCoverId());
        resp.setDistributionChannel(task.getDistributionChannel());
        resp.setStatus(task.getStatus());
        resp.setResultMessage(task.getResultMessage());
        return resp;
    }
}
