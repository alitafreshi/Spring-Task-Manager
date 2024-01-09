package com.alitafreshi.task_manager.comment.controller;

import com.alitafreshi.task_manager.comment.model.Comment;
import com.alitafreshi.task_manager.comment.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/newComment")
    public Comment insertNewCommentByTaskId(@RequestBody Comment newComment) {
        return commentService.insertNewCommentByTaskId(newComment);
    }

    @GetMapping("/commentList/{taskId}")
    public List<Comment> getAllCommentsByTaskId(@PathVariable("taskId") Long taskId) {
        return commentService.getAllCommentsByTaskId(taskId);
    }

    @DeleteMapping("/deleteComment/{commentId}")
    public String removeCommentById(@PathVariable("commentId") Long commentId) {
        return commentService.removeCommentById(commentId);
    }

}
