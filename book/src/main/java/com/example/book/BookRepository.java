package com.example.book;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RepositoryRestResource(path="book")
public interface BookRepository extends ReactiveCrudRepository<Book, Integer> {
    Mono<Book> findByTitle(String title);
}
