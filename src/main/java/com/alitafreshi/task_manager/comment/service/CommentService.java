package com.alitafreshi.task_manager.comment.service;

import com.alitafreshi.task_manager.comment.model.Comment;
import com.alitafreshi.task_manager.comment.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment insertNewCommentByTaskId(Comment newComment) {
        return commentRepository.save(newComment);
    }

    public List<Comment> getAllCommentsByTaskId(Long taskId){
        return commentRepository.findByTaskId(taskId);
    }
}
