package com.alitafreshi.task_manager.comment.controller;

import com.alitafreshi.task_manager.comment.model.Comment;
import com.alitafreshi.task_manager.comment.service.CommentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
