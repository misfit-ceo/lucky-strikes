package com.misfitpoets.aggregator.repositories;

import com.misfitpoets.aggregator.domain.AggregatedRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AggregatedRecordRepository extends JpaRepository<AggregatedRecord, Long> {
    // Additional custom queries if needed
}
