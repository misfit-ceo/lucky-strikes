package com.misfitpoets.scrappyscraps.repositories;

import com.misfitpoets.scrappyscraps.domain.ScrapEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScrapEntryRepository extends JpaRepository<ScrapEntry, Long> {
    // Additional queries if needed
}
