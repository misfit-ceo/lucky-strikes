package com.misfitpoets.manuscriptprep.services;

import com.misfitpoets.manuscriptprep.domain.PrepTask;
import com.misfitpoets.manuscriptprep.dto.PrepRequest;
import com.misfitpoets.manuscriptprep.dto.PrepResponse;
import com.misfitpoets.manuscriptprep.exceptions.PrepTaskNotFoundException;
import com.misfitpoets.manuscriptprep.repositories.PrepTaskRepository;
import com.misfitpoets.manuscriptprep.util.PrepMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrepService {

    private final PrepTaskRepository repo;
    private final PrepMapper mapper;
    private final ConversionEngine conversionEngine;

    public PrepService(PrepTaskRepository repo, PrepMapper mapper, ConversionEngine conversionEngine) {
        this.repo = repo;
        this.mapper = mapper;
        this.conversionEngine = conversionEngine;
    }

    public PrepResponse submitTask(PrepRequest req) {
        PrepTask task = mapper.toEntity(req);
        // set initial status
        task.setStatus("PENDING");
        // set outputFormat from the request
        task.setOutputFormat(req.getDesiredFormat() != null ? req.getDesiredFormat().toUpperCase() : "DOCX");
        task = repo.save(task);
        return mapper.toResponse(task);
    }

    public List<PrepResponse> listTasks() {
        return repo.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public PrepResponse getTask(Long id) {
        PrepTask task = repo.findById(id)
                .orElseThrow(() -> new PrepTaskNotFoundException("PrepTask not found: " + id));
        return mapper.toResponse(task);
    }

    public PrepResponse completeTask(Long id) {
        PrepTask task = repo.findById(id)
                .orElseThrow(() -> new PrepTaskNotFoundException("Cannot complete. Task not found: " + id));

        task.setStatus("IN_PROGRESS");
        // pretend we do advanced editing or reformatting here
        String convertedContent = conversionEngine.performConversion(task.getDocContent(), task.getOutputFormat());
        task.setDocContent(convertedContent);

        task.setStatus("COMPLETE");
        task = repo.save(task);
        return mapper.toResponse(task);
    }

    public void deleteTask(Long id) {
        PrepTask task = repo.findById(id)
                .orElseThrow(() -> new PrepTaskNotFoundException("Cannot delete. Task not found: " + id));
        repo.delete(task);
    }
}
