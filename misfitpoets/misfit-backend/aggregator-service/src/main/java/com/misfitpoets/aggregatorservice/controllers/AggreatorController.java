// AggregatorController.java
// Location: misfitpoets/misfitpoets-backend/aggregator-service/src/main/java/com/misfitpoets/aggregatorservice/controllers/AggregatorController.java
package com.misfitpoets.aggregatorservice.controllers;

import com.misfitpoets.aggregatorservice.models.BookRecord;
import com.misfitpoets.aggregatorservice.services.AggregatorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aggregator")
public class AggregatorController {

    private final AggregatorService aggregatorService;

    public AggregatorController(AggregatorService aggregatorService) {
        this.aggregatorService = aggregatorService;
    }

    @PostMapping("/fetch")
    public List<BookRecord> fetchData(@RequestBody String query) {
        // Fetch external data based on query
        return aggregatorService.fetchData(query);
    }

    @GetMapping("/records")
    public List<BookRecord> getRecords() {
        return aggregatorService.getAllRecords();
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "Aggregator Service is running.";
    }
}
