package com.example.comment;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CommentService {
    CommentRepository commentRepository;

    public Mono<Comment> getCommentById(Integer id) {
        return commentRepository.findById(id);
    }

    public Mono<Comment> getCommentByTitle(String title){
        return commentRepository.findByTitle(title);
    }
}
