package com.misfitpoets.manuscriptprep.util;

import com.misfitpoets.manuscriptprep.domain.PrepTask;
import com.misfitpoets.manuscriptprep.dto.PrepRequest;
import com.misfitpoets.manuscriptprep.dto.PrepResponse;
import org.springframework.stereotype.Component;

@Component
public class PrepMapper {

    public PrepTask toEntity(PrepRequest req) {
        PrepTask task = new PrepTask();
        task.setDocTitle(req.getDocTitle());
        task.setDocContent(req.getDocContent());
        task.setOwnerId(req.getOwnerId());
        return task;
    }

    public PrepResponse toResponse(PrepTask task) {
        PrepResponse resp = new PrepResponse();
        resp.setId(task.getId());
        resp.setDocTitle(task.getDocTitle());
        resp.setDocContent(task.getDocContent());
        resp.setOwnerId(task.getOwnerId());
        resp.setStatus(task.getStatus());
        resp.setOutputFormat(task.getOutputFormat());
        return resp;
    }
}
