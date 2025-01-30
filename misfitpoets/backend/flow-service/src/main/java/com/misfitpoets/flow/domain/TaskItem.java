package com.misfitpoets.flow.domain;

import com.misfitpoets.flow.domain.enums.TaskStatus;

import javax.persistence.*;

@Entity
@Table(name = "task_items")
public class TaskItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    // Example: store an ID to associate with user or project
    private String ownerId;

    // Could add a dueDate, priority, etc.

    // Constructors, getters, setters
}
