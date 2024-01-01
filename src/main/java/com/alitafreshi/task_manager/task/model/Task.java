package com.alitafreshi.task_manager.task.model;

import com.alitafreshi.task_manager.comment.model.Comment;
import com.alitafreshi.task_manager.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Table(name = "tbl_tasks")
@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long task_id;

    @Column(name = "task_name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "task_description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "user_id")
    private Integer userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_priority", nullable = false)
    private TaskPriority taskPriority;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_status", nullable = false)
    private TaskStatus taskStatus;

    @Column(name = "task_creation_date_time", nullable = false, columnDefinition = "TEXT")
    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @Column(name = "task_dead_line", nullable = false, columnDefinition = "TEXT")
    private LocalDateTime deadLine;

    @JsonIgnore
    @OneToMany
    @JoinColumn(name = "task_id")
    private Set<Comment> commentList;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;
}
