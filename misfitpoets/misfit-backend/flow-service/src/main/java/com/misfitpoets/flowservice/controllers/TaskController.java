// TaskController.java
// Location: misfitpoets/misfitpoets-backend/flow-service/src/main/java/com/misfitpoets/flowservice/controllers/TaskController.java
package com.misfitpoets.flowservice.controllers;

import com.misfitpoets.flowservice.models.Task;
import com.misfitpoets.flowservice.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flow/tasks")
public class TaskController {

    private final TaskService taskService;
    
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * POST /api/flow/tasks
     * Create a new task.
     */
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    /**
     * GET /api/flow/tasks
     * Retrieve all tasks.
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * GET /api/flow/tasks/{id}
     * Retrieve task details by ID.
     */
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));
    }

    /**
     * PUT /api/flow/tasks/{id}
     * Update task details or status.
     */
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    /**
     * DELETE /api/flow/tasks/{id}
     * Delete a task.
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
