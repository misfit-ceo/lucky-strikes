// DistributionController.java
// Location: misfitpoets/misfitpoets-backend/distribution-service/src/main/java/com/misfitpoets/distributionservice/controllers/DistributionController.java
package com.misfitpoets.distributionservice.controllers;

import com.misfitpoets.distributionservice.models.DistributionTask;
import com.misfitpoets.distributionservice.services.DistributionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/distribution")
public class DistributionController {

    private final DistributionService distributionService;

    public DistributionController(DistributionService distributionService) {
        this.distributionService = distributionService;
    }

    /**
     * POST /api/distribution/request
     * Submit a new book for distribution.
     *
     * @param task A JSON object representing the distribution task details.
     * @return The created DistributionTask.
     */
    @PostMapping("/request")
    public DistributionTask submitTask(@RequestBody DistributionTask task) {
        return distributionService.submitTask(task);
    }

    /**
     * POST /api/distribution/tasks/{id}/start
     * Start the distribution process for a specific task.
     *
     * @param id The distribution task ID.
     * @return The updated DistributionTask.
     */
    @PostMapping("/tasks/{id}/start")
    public DistributionTask startTask(@PathVariable Long id) {
        return distributionService.startTask(id);
    }

    /**
     * GET /api/distribution/tasks
     * Retrieve all distribution tasks.
     *
     * @return List of DistributionTask objects.
     */
    @GetMapping("/tasks")
    public List<DistributionTask> getAllTasks() {
        return distributionService.getAllTasks();
    }
}
