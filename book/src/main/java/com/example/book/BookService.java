package com.example.book;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Transactional
public class BookService {

    @Autowired
    private final BookRepository bookRepository;

    public Mono<Book> findById(int id){
        return bookRepository.findById(id);
    }

    public Mono<Book> findByTitle(String title){
        return bookRepository.findBookByTitle(title);
    }

    public Flux<Book> findAll() {
        return bookRepository.findAll();
    }

    public Mono<Book> addBook(Book book) {
        if (!book.getCategory().equals("adulte") && !book.getCategory().equals("adolescent") && !book.getCategory().equals("enfant")) {
            book.setCategory("adulte");
        }
        return bookRepository.save(book.setAsNew());
    }

    public Mono<Void> deleteBook(int bookId) {
        return bookRepository.deleteById(bookId);
    }

    public Mono<Book> updateBook(Book book) {
        return bookRepository.save(book);
    }
}
