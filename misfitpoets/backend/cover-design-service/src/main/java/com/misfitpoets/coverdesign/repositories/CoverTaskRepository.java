package com.misfitpoets.coverdesign.repositories;

import com.misfitpoets.coverdesign.domain.CoverTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverTaskRepository extends JpaRepository<CoverTask, Long> {
    // Additional queries if needed
}
