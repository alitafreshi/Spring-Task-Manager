package com.alitafreshi.task_manager.comment.model;

import com.alitafreshi.task_manager.task.model.Task;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "tbl_comments")
@Entity
@Data
public class Comment {
    @Schema(description = "comment id we will insert or find comment with this param later on")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long comment_id;

    @Schema(description = "comment description which is a describe a problem or some thing")
    @Column(name = "comment_description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Schema(description = "the task which is this comment bound to it")
    @Column(name = "task_id")
    private Integer taskId;

    @Schema(description = "task complete information for this comment")
    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "task_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnoreProperties("commentList")
    private Task task;
}
