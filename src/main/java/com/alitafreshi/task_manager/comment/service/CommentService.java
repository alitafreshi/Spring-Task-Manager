package com.alitafreshi.task_manager.comment.service;

import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentService commentService;

    public CommentService(CommentService commentService) {
        this.commentService = commentService;
    }
}
