package com.misfitpoets.scrappyscraps.services;

import com.misfitpoets.scrappyscraps.domain.ScrapEntry;
import com.misfitpoets.scrappyscraps.dto.ScrapRequest;
import com.misfitpoets.scrappyscraps.dto.ScrapResponse;
import com.misfitpoets.scrappyscraps.exceptions.ScrapNotFoundException;
import com.misfitpoets.scrappyscraps.repositories.ScrapEntryRepository;
import com.misfitpoets.scrappyscraps.util.ScrappyMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScrappyScrapsService {

    private final ScrapEntryRepository repo;
    private final ScrappyMapper mapper;
    private final ExternalFetcher fetcher;

    public ScrappyScrapsService(ScrapEntryRepository repo, ScrappyMapper mapper, ExternalFetcher fetcher) {
        this.repo = repo;
        this.mapper = mapper;
        this.fetcher = fetcher;
    }

    public ScrapResponse createScrap(ScrapRequest req) {
        ScrapEntry entry = mapper.toEntity(req);
        entry = repo.save(entry);
        return mapper.toResponse(entry);
    }

    public List<ScrapResponse> listScraps() {
        return repo.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public ScrapResponse getScrap(Long id) {
        ScrapEntry entry = repo.findById(id)
                .orElseThrow(() -> new ScrapNotFoundException("Scrap not found: " + id));
        return mapper.toResponse(entry);
    }

    public ScrapResponse updateScrap(Long id, ScrapRequest req) {
        ScrapEntry existing = repo.findById(id)
                .orElseThrow(() -> new ScrapNotFoundException("Cannot update. Scrap not found: " + id));

        existing.setTitle(req.getTitle());
        existing.setSummary(req.getSummary());
        existing.setSourceUrl(req.getSourceUrl());
        existing.setCategory(req.getCategory());
        existing.setExternalId(req.getExternalId());

        existing = repo.save(existing);
        return mapper.toResponse(existing);
    }

    public void deleteScrap(Long id) {
        ScrapEntry existing = repo.findById(id)
                .orElseThrow(() -> new ScrapNotFoundException("Cannot delete. Scrap not found: " + id));
        repo.delete(existing);
    }

    public List<ScrapResponse> fetchAndStore(String url) {
        // Let's fetch external data via the ExternalFetcher
        List<ScrapEntry> newScraps = fetcher.fetchDataFromSource(url);

        // Save them in DB
        newScraps.forEach(repo::save);
        // Convert to response
        return newScraps.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
