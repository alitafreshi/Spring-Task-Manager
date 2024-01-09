package com.alitafreshi.task_manager.comment.controller;

import com.alitafreshi.task_manager.comment.model.Comment;
import com.alitafreshi.task_manager.comment.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@Tag(name = "Comment Apis")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/newComment")
    @Operation(summary = "insert new comment by task is")
    public Comment insertNewCommentByTaskId(@RequestBody Comment newComment) {
        return commentService.insertNewCommentByTaskId(newComment);
    }

    @GetMapping("/commentList/{taskId}")
    @Operation(summary = "get all comments related to a task")
    public List<Comment> getAllCommentsByTaskId(@PathVariable("taskId") Long taskId) {
        return commentService.getAllCommentsByTaskId(taskId);
    }

    @DeleteMapping("/deleteComment/{commentId}")
    @Operation(summary = "remove a comment by id")
    public String removeCommentById(@PathVariable("commentId") Long commentId) {
        return commentService.removeCommentById(commentId);
    }

}
