package com.misfitpoets.flow.repositories;

import com.misfitpoets.flow.domain.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskItemRepository extends JpaRepository<TaskItem, Long> {
    // Additional custom queries if needed
}
