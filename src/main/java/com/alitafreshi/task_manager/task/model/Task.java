package com.alitafreshi.task_manager.task.model;

import com.alitafreshi.task_manager.comment.model.Comment;
import com.alitafreshi.task_manager.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "tbl_tasks")
@Entity
@Data
public class Task {
    @Schema(description = "task id we will insert or find tasks with this param later on")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long task_id;
    @Schema(description = "task name")
    @Column(name = "task_name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Schema(description = "a brief description for a task ")
    @Column(name = "task_description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Schema(description = "the user id that create this task")
    @Column(name = "user_id")
    private Integer userId;

    @Schema(description = "task priority which is defined by user (task creator)")
    @Enumerated(EnumType.STRING)
    @Column(name = "task_priority", nullable = false)
    private TaskPriority taskPriority;

    @Schema(description = "task task_status which is updated by user during a time")
    @Enumerated(EnumType.STRING)
    @Column(name = "task_status", nullable = false)
    private TaskStatus taskStatus;

    @Schema(description = "created date for the task which is time stamp")
    @Column(name = "task_creation_date_time", nullable = false, columnDefinition = "TEXT")
    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @Schema(description = "task dead line which is define by user (task creator)")
    @Column(name = "task_dead_line", nullable = false, columnDefinition = "TEXT")
    private LocalDateTime deadLine;
    @Schema(description = "list of comment for a task")
    @OneToMany(mappedBy = "task", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<Comment> commentList;

    @Schema(description = "a user information which is creates this task")
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @JsonIgnoreProperties("taskList")
    private User user;
}
