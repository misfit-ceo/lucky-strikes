package com.misfitpoets.flow.util;

import com.misfitpoets.flow.domain.TaskItem;
import com.misfitpoets.flow.domain.enums.TaskStatus;
import com.misfitpoets.flow.dto.TaskRequest;
import com.misfitpoets.flow.dto.TaskResponse;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskItem toEntity(TaskRequest req) {
        TaskItem entity = new TaskItem();
        entity.setTitle(req.getTitle());
        entity.setDescription(req.getDescription());
        entity.setOwnerId(req.getOwnerId());
        // Default to TODO if not recognized
        try {
            entity.setStatus(TaskStatus.valueOf(req.getStatus().toUpperCase()));
        } catch (Exception e) {
            entity.setStatus(TaskStatus.TODO);
        }
        return entity;
    }

    public TaskResponse toResponse(TaskItem item) {
        TaskResponse resp = new TaskResponse();
        resp.setId(item.getId());
        resp.setTitle(item.getTitle());
        resp.setDescription(item.getDescription());
        resp.setStatus(item.getStatus().name());
        resp.setOwnerId(item.getOwnerId());
        return resp;
    }
}
