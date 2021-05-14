package com.example.comment;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CommentRepository extends ReactiveCrudRepository<Comment, Integer> {
    Mono<Comment> findByTitle(String title);
}
