// TaskRepository.java
// Location: misfitpoets/misfitpoets-backend/flow-service/src/main/java/com/misfitpoets/flowservice/repositories/TaskRepository.java
package com.misfitpoets.flowservice.repositories;

import com.misfitpoets.flowservice.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Additional custom query methods can be added here if needed
}
