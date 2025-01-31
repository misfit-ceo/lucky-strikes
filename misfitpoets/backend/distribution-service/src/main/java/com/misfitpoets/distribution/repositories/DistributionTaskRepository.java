package com.misfitpoets.distribution.repositories;

import com.misfitpoets.distribution.domain.DistributionTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistributionTaskRepository extends JpaRepository<DistributionTask, Long> {
    // Additional queries if needed
}
