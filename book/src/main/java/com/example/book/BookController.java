package com.example.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path="/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Flux<Book> getBooks(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Book> getBook(@PathVariable("id") int id) {
        return bookService.findById(id);
    }

    @GetMapping("/search/{title}")
    public Mono<Book> searchBook(@PathVariable("title") String title) {
        return bookService.findByTitle(title);
    }

    @PostMapping("")
    public Mono<Book> addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping("/{bookId}")
    public Mono<Void> deleteBook(@PathVariable("bookId") int bookId) {
        return bookService.deleteBook(bookId);
    }

    @PutMapping("")
    public Mono<Book> updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }
}
