package com.misfitpoets.aggregator.services;

import com.misfitpoets.aggregator.domain.AggregatedRecord;
import com.misfitpoets.aggregator.dto.AggregatorRequest;
import com.misfitpoets.aggregator.dto.AggregatorResponse;
import com.misfitpoets.aggregator.exceptions.RecordNotFoundException;
import com.misfitpoets.aggregator.repositories.AggregatedRecordRepository;
import com.misfitpoets.aggregator.util.AggregatorMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AggregatorService {

    private final AggregatedRecordRepository recordRepo;
    private final AggregatorMapper mapper;

    public AggregatorService(AggregatedRecordRepository recordRepo,
                             AggregatorMapper mapper) {
        this.recordRepo = recordRepo;
        this.mapper = mapper;
    }

    public AggregatorResponse fetchAndAggregate(AggregatorRequest req) {
        // 1) Possibly fetch external data from 'req.getSource()', 'req.getQuery()'
        // 2) Process or transform data
        String processed = "Data fetched from: " + req.getSource() 
                          + " using query: " + req.getQuery() 
                          + " [placeholder data]";

        // 3) Save as AggregatedRecord
        AggregatedRecord record = new AggregatedRecord();
        record.setSourceName(req.getSource());
        record.setRawData(req.getQuery());
        record.setProcessedData(processed);

        record = recordRepo.save(record);
        return mapper.toResponse(record);
    }

    public List<AggregatorResponse> listAll() {
        return recordRepo.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public AggregatorResponse getById(Long id) {
        AggregatedRecord found = recordRepo.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("No record found with ID " + id));
        return mapper.toResponse(found);
    }
}
