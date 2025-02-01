package com.misfitpoets.scrappyscraps.controllers;

import com.misfitpoets.scrappyscraps.dto.ScrapRequest;
import com.misfitpoets.scrappyscraps.dto.ScrapResponse;
import com.misfitpoets.scrappyscraps.services.ScrappyScrapsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scraps")
public class ScrappyController {

    private final ScrappyScrapsService scrappyService;

    public ScrappyController(ScrappyScrapsService scrappyService) {
        this.scrappyService = scrappyService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "scrappy-scraps-service is up!";
    }

    // 1) Manual insertion of a scrap (e.g., user discovered something and wants to store it)
    @PostMapping
    public ResponseEntity<ScrapResponse> createScrap(@RequestBody ScrapRequest request) {
        return ResponseEntity.ok(scrappyService.createScrap(request));
    }

    // 2) List all scraps
    @GetMapping
    public ResponseEntity<List<ScrapResponse>> listScraps() {
        return ResponseEntity.ok(scrappyService.listScraps());
    }

    // 3) Get detail of a single scrap
    @GetMapping("/{id}")
    public ResponseEntity<ScrapResponse> getScrap(@PathVariable Long id) {
        return ResponseEntity.ok(scrappyService.getScrap(id));
    }

    // 4) Update scrap (e.g., fix title or summary)
    @PutMapping("/{id}")
    public ResponseEntity<ScrapResponse> updateScrap(@PathVariable Long id,
                                                     @RequestBody ScrapRequest request) {
        return ResponseEntity.ok(scrappyService.updateScrap(id, request));
    }

    // 5) Delete a scrap
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScrap(@PathVariable Long id) {
        scrappyService.deleteScrap(id);
        return ResponseEntity.noContent().build();
    }

    // 6) Trigger external fetch (on-demand) — e.g., fetch new scraps from a specific site
    @PostMapping("/fetch")
    public ResponseEntity<List<ScrapResponse>> fetchNewScraps(@RequestBody ScrapRequest request) {
        // request might hold the "url" or "rss feed"
        List<ScrapResponse> results = scrappyService.fetchAndStore(request.getSourceUrl());
        return ResponseEntity.ok(results);
    }
}
