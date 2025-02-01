// BookRecordRepository.java
// Location: misfitpoets/misfitpoets-backend/aggregator-service/src/main/java/com/misfitpoets/aggregatorservice/repositories/BookRecordRepository.java
package com.misfitpoets.aggregatorservice.repositories;

import com.misfitpoets.aggregatorservice.models.BookRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRecordRepository extends JpaRepository<BookRecord, Long> {
    // Additional custom query methods can be defined here if needed
}
