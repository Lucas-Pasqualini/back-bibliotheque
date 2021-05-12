package com.example.customer;

import com.example.book.Book;
import com.example.book.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Set;

@Service
@AllArgsConstructor
public class CustomerService {
    CustomerRepository customerRepository;
    BookRepository bookRepository;

    public Mono<Customer> addCustomer(Customer customer) throws RuntimeException{
        if(customer.getAge() > 0 && customer.getAge() < 13) {
            customer.setCategory("Enfant");
        } else if(customer.getAge() >= 13 && customer.getAge() < 18) {
            customer.setCategory("Ado");
        } else if(customer.getAge() >= 18) {
            customer.setCategory("adulte");
        } else {
            throw new RuntimeException("Wrong age");
        }
        return customerRepository.save(customer);
    }

    public Mono<Customer> getCustomerByName(String userName){
        return customerRepository.findByName(userName);
    }

    public Mono<Customer> updateCustomer( int userId, int bookId) throws Exception {
        Mono<Customer> customer = customerRepository.findById(userId);
                // .orElseThrow(() -> new RuntimeException("Customer not found for this id :: " + userId));

        Mono<Book> book = bookRepository.findById(bookId);
                // .orElseThrow(() -> new RuntimeException("Book not found for this id :: " + bookId));

        Boolean checkEnfant = customer.getCategory().equals("enfant") && (book.getCategory().equals("adolescent") || book.getCategory().equals("adulte"));
        Boolean checkAdo = customer.getCategory().equals("adolescent") && book.getCategory().equals("adulte");

        if(checkEnfant || checkAdo){
            throw new RuntimeException("You are not old enough to borrow this book.");
        }

        Set<Mono<Book>> borrow = customer.getBorrow();

        if(borrow.size() >= 3){
            throw new Exception("Too many borrowed books");
        } else{
            borrow.add(book);
        }

        customer.setBorrow(borrow);

        final Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }
}
