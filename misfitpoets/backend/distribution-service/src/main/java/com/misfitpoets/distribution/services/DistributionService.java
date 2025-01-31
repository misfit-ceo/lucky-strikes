package com.misfitpoets.distribution.services;

import com.misfitpoets.distribution.domain.DistributionTask;
import com.misfitpoets.distribution.dto.DistRequest;
import com.misfitpoets.distribution.dto.DistResponse;
import com.misfitpoets.distribution.exceptions.DistributionTaskNotFoundException;
import com.misfitpoets.distribution.repositories.DistributionTaskRepository;
import com.misfitpoets.distribution.util.DistMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistributionService {

    private final DistributionTaskRepository repo;
    private final DistMapper mapper;
    private final ExternalConnector externalConnector;

    public DistributionService(DistributionTaskRepository repo, DistMapper mapper, ExternalConnector externalConnector) {
        this.repo = repo;
        this.mapper = mapper;
        this.externalConnector = externalConnector;
    }

    public DistResponse requestDistribution(DistRequest request) {
        DistributionTask task = mapper.toEntity(request);
        task.setStatus("REQUESTED");
        task = repo.save(task);
        return mapper.toResponse(task);
    }

    public List<DistResponse> listTasks() {
        return repo.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public DistResponse getTask(Long id) {
        DistributionTask task = repo.findById(id)
                .orElseThrow(() -> new DistributionTaskNotFoundException("Dist task not found: " + id));
        return mapper.toResponse(task);
    }

    public DistResponse startDistribution(Long id) {
        DistributionTask task = repo.findById(id)
                .orElseThrow(() -> new DistributionTaskNotFoundException("Cannot start. Task not found: " + id));

        task.setStatus("IN_PROGRESS");
        repo.save(task);

        // Interact with external aggregator or direct marketplace
        String outcome = externalConnector.pushToMarketplace(task.getManuscriptId(), task.getCoverId(), task.getDistributionChannel());
        task.setResultMessage(outcome);
        task.setStatus("COMPLETED");
        repo.save(task);

        return mapper.toResponse(task);
    }

    public void deleteTask(Long id) {
        DistributionTask task = repo.findById(id)
                .orElseThrow(() -> new DistributionTaskNotFoundException("Cannot delete. Task not found: " + id));
        repo.delete(task);
    }
}
