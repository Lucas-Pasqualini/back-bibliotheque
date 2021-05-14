package com.example.comment;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CommentService {

    @Autowired
    private final CommentRepository commentRepository;

    public Mono<Comment> findById(int id){
        return commentRepository.findById(id);
    }

    public Mono<Comment> findByTitle(String title){
        return commentRepository.findByTitle(title);
    }

    public Flux<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Mono<Comment> addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(int bookId) {
        commentRepository.deleteById(bookId);
    }

    public Mono<Comment> updateComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
