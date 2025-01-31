package com.misfitpoets.coverdesign.services;

import com.misfitpoets.coverdesign.domain.CoverTask;
import com.misfitpoets.coverdesign.dto.CoverRequest;
import com.misfitpoets.coverdesign.dto.CoverResponse;
import com.misfitpoets.coverdesign.exceptions.CoverTaskNotFoundException;
import com.misfitpoets.coverdesign.repositories.CoverTaskRepository;
import com.misfitpoets.coverdesign.util.CoverMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoverService {

    private final CoverTaskRepository repo;
    private final CoverMapper mapper;
    private final AiMockupEngine aiMockupEngine;

    public CoverService(CoverTaskRepository repo, CoverMapper mapper, AiMockupEngine aiMockupEngine) {
        this.repo = repo;
        this.mapper = mapper;
        this.aiMockupEngine = aiMockupEngine;
    }

    public CoverResponse requestCover(CoverRequest req) {
        // Create a new cover task
        CoverTask task = mapper.toEntity(req);
        task.setStatus("REQUESTED");
        task = repo.save(task);

        // Possibly trigger AI generation asynchronously
        // For demonstration, let's say we do it right now
        String generatedUrl = aiMockupEngine.generateMockup(task.getStyleDescription(), task.getBookTitle());
        task.setCoverUrl(generatedUrl);
        task.setStatus("IN_PROGRESS");
        repo.save(task);

        return mapper.toResponse(task);
    }

    public List<CoverResponse> listCovers() {
        return repo.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public CoverResponse getCover(Long id) {
        CoverTask task = repo.findById(id)
                .orElseThrow(() -> new CoverTaskNotFoundException("Cover task not found: " + id));
        return mapper.toResponse(task);
    }

    public CoverResponse finalizeCover(Long id) {
        CoverTask task = repo.findById(id)
                .orElseThrow(() -> new CoverTaskNotFoundException("Cannot finalize. Task not found: " + id));

        // Possibly call AI or user-designed tweak finalization
        // We'll just mark status as done
        task.setStatus("DONE");
        repo.save(task);

        return mapper.toResponse(task);
    }

    public void deleteCover(Long id) {
        CoverTask task = repo.findById(id)
                .orElseThrow(() -> new CoverTaskNotFoundException("Cannot delete. Task not found: " + id));
        repo.delete(task);
    }
}
