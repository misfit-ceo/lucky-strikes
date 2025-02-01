// DistributionTaskRepository.java
// Location: misfitpoets/misfitpoets-backend/distribution-service/src/main/java/com/misfitpoets/distributionservice/repositories/DistributionTaskRepository.java
package com.misfitpoets.distributionservice.repositories;

import com.misfitpoets.distributionservice.models.DistributionTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistributionTaskRepository extends JpaRepository<DistributionTask, Long> {
    // Additional custom query methods can be defined here if needed
}
