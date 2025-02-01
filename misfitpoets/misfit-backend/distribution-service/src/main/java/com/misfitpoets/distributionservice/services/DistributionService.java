// DistributionService.java
// Location: misfitpoets/misfitpoets-backend/distribution-service/src/main/java/com/misfitpoets/distributionservice/services/DistributionService.java
package com.misfitpoets.distributionservice.services;

import com.misfitpoets.distributionservice.models.DistributionTask;
import com.misfitpoets.distributionservice.repositories.DistributionTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistributionService {

    private final DistributionTaskRepository distributionTaskRepository;

    public DistributionService(DistributionTaskRepository distributionTaskRepository) {
        this.distributionTaskRepository = distributionTaskRepository;
    }

    /**
     * Submits a new book for distribution.
     *
     * @param task The distribution task details.
     * @return The created DistributionTask object.
     */
    public DistributionTask submitTask(DistributionTask task) {
        task.setStatus("PENDING");
        return distributionTaskRepository.save(task);
    }

    /**
     * Starts the distribution process for a specific task.
     * In production, this method might interact with external APIs to publish the book.
     *
     * @param taskId The ID of the distribution task.
     * @return The updated DistributionTask object.
     */
    public DistributionTask startTask(Long taskId) {
        Optional<DistributionTask> taskOptional = distributionTaskRepository.findById(taskId);
        if (taskOptional.isPresent()) {
            DistributionTask task = taskOptional.get();
            // Simulate starting the distribution process
            task.setStatus("IN_PROGRESS");
            return distributionTaskRepository.save(task);
        } else {
            throw new RuntimeException("Distribution task not found with id " + taskId);
        }
    }

    /**
     * Retrieves all distribution tasks.
     *
     * @return List of DistributionTask objects.
     */
    public List<DistributionTask> getAllTasks() {
        return distributionTaskRepository.findAll();
    }
}
