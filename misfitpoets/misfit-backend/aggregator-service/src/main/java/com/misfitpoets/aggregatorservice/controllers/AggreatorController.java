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

    /**
     * POST /api/aggregator/fetch
     * Fetch data from external sources based on the provided query.
     *
     * @param request A JSON object containing "query".
     * @return A list of newly fetched BookRecord objects.
     */
    @PostMapping("/fetch")
    public List<BookRecord> fetchData(@RequestBody FetchRequest request) {
        return aggregatorService.fetchData(request.getQuery());
    }

    /**
     * GET /api/aggregator/records
     * Retrieve all aggregated book records.
     *
     * @return A list of BookRecord objects.
     */
    @GetMapping("/records")
    public List<BookRecord> getAllRecords() {
        return aggregatorService.getAllRecords();
    }

    /**
     * GET /api/aggregator/health
     * Health check endpoint.
     *
     * @return A simple health message.
     */
    @GetMapping("/health")
    public String healthCheck() {
        return "Aggregator Service is running.";
    }
    
    // Request DTO for fetching data
    public static class FetchRequest {
        private String query;

        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }
    }
}
