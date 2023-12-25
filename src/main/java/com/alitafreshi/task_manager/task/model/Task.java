package com.alitafreshi.task_manager.task.model;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public class Task {
    private Long id;
    private String name;
    private String description;
    private Integer assignTo;
    private TaskPriority taskPriority;
    private TaskStatus taskStatus;
    @CreationTimestamp
    private LocalDateTime creationDateTime;
    private LocalDateTime deadLine;
}
