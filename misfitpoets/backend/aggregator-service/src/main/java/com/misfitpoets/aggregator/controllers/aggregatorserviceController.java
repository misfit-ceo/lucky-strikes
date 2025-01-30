package com.misfitpoets.aggregator.controllers;

import com.misfitpoets.aggregator.dto.AggregatorRequest;
import com.misfitpoets.aggregator.dto.AggregatorResponse;
import com.misfitpoets.aggregator.services.AggregatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aggregator")
public class AggregatorController {

    private final AggregatorService aggregatorService;

    public AggregatorController(AggregatorService aggregatorService) {
        this.aggregatorService = aggregatorService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "aggregator-service is up!";
    }

    @PostMapping("/fetch")
    public ResponseEntity<AggregatorResponse> fetchData(@RequestBody AggregatorRequest request) {
        AggregatorResponse response = aggregatorService.fetchAndAggregate(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/records")
    public ResponseEntity<List<AggregatorResponse>> listRecords() {
        List<AggregatorResponse> allRecs = aggregatorService.listAll();
        return ResponseEntity.ok(allRecs);
    }
}
