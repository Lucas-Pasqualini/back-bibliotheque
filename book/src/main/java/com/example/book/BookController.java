package com.example.book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path="api/book")
public class BookController {
    BookService bookService;

    @GetMapping("/{id}")
    public Mono<Book> getBook(@PathVariable("id") Integer id) {
        return bookService.findById(id);
    }

    @GetMapping("/search/{title}")
    public Mono<Book> searchBook(@PathVariable("title") String title) {
        return bookService.findByTitle(title);
    }
}
