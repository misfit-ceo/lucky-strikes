package com.misfitpoets.flow.services;

import com.misfitpoets.flow.domain.TaskItem;
import com.misfitpoets.flow.domain.enums.TaskStatus;
import com.misfitpoets.flow.dto.TaskRequest;
import com.misfitpoets.flow.dto.TaskResponse;
import com.misfitpoets.flow.exceptions.TaskNotFoundException;
import com.misfitpoets.flow.repositories.TaskItemRepository;
import com.misfitpoets.flow.util.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlowService {

    private final TaskItemRepository taskRepo;
    private final TaskMapper mapper;

    public FlowService(TaskItemRepository taskRepo, TaskMapper mapper) {
        this.taskRepo = taskRepo;
        this.mapper = mapper;
    }

    public TaskResponse createTask(TaskRequest req) {
        TaskItem item = mapper.toEntity(req);
        item = taskRepo.save(item);
        return mapper.toResponse(item);
    }

    public List<TaskResponse> listTasks() {
        return taskRepo.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public TaskResponse getTask(Long id) {
        TaskItem found = taskRepo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with ID: " + id));
        return mapper.toResponse(found);
    }

    public TaskResponse updateTask(Long id, TaskRequest req) {
        TaskItem found = taskRepo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Cannot update. Task ID " + id + " not found."));

        // Update fields
        found.setTitle(req.getTitle());
        found.setDescription(req.getDescription());
        found.setOwnerId(req.getOwnerId());
        try {
            found.setStatus(TaskStatus.valueOf(req.getStatus().toUpperCase()));
        } catch (Exception e) {
            found.setStatus(TaskStatus.TODO);
        }

        found = taskRepo.save(found);
        return mapper.toResponse(found);
    }

    public void deleteTask(Long id) {
        TaskItem found = taskRepo.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Cannot delete. Task ID " + id + " not found."));
        taskRepo.delete(found);
    }
}