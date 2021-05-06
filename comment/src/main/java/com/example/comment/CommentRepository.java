package com.example.comment;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RepositoryRestResource(path="comment")
public interface CommentRepository extends ReactiveCrudRepository<Comment, Integer> {
    Mono<Comment> findByTitle(String title);
}
