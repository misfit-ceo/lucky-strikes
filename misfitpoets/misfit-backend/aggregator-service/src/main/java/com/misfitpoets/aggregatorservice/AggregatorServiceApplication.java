// AggregatorService.java
// Location: misfitpoets/misfitpoets-backend/aggregator-service/src/main/java/com/misfitpoets/aggregatorservice/services/AggregatorService.java
package com.misfitpoets.aggregatorservice.services;

import com.misfitpoets.aggregatorservice.models.BookRecord;
import com.misfitpoets.aggregatorservice.repositories.BookRecordRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AggregatorService {

    private final BookRecordRepository bookRecordRepository;

    public AggregatorService(BookRecordRepository bookRecordRepository) {
        this.bookRecordRepository = bookRecordRepository;
    }

    /**
     * Simulate fetching data from an external source based on a query.
     * In production, this method could call external APIs (e.g., Google Books).
     *
     * @param query The search query.
     * @return A list of BookRecord objects.
     */
    public List<BookRecord> fetchData(String query) {
        // Simulated data fetching logic for MVP:
        // In a real implementation, integrate with external APIs.
        List<BookRecord> results = new ArrayList<>();
        results.add(new BookRecord("Example Book: " + query, "Author A", "Simulated Source", "Description for " + query));
        // Save fetched records to the repository for demonstration purposes.
        return bookRecordRepository.saveAll(results);
    }

    /**
     * Retrieve all aggregated book records.
     *
     * @return List of BookRecord objects.
     */
    public List<BookRecord> getAllRecords() {
        return bookRecordRepository.findAll();
    }
}
