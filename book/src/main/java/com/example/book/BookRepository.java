package com.example.book;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface BookRepository extends ReactiveCrudRepository<Book, Integer> {
    Mono<Book> findBookByTitle(String title);
}
