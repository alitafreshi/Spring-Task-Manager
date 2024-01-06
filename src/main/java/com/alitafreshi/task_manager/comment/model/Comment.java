package com.alitafreshi.task_manager.comment.model;

import com.alitafreshi.task_manager.task.model.Task;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "tbl_comments")
@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long comment_id;

    @Column(name = "comment_description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "task_id", nullable = false)
    private Task task;
}
