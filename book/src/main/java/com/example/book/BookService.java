package com.example.book;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class BookService {
    BookRepository bookRepository;

    public Mono<Book> findById(int id){
        return bookRepository.findById(id);
    }

    public Mono<Book> findByTitle(String title){
        return bookRepository.findByTitle(title);
    }
}
