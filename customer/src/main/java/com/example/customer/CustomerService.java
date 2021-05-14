package com.example.customer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Transactional
public class CustomerService {

    @Autowired
    private final CustomerRepository customerRepository;

    public Mono<Customer> findById(int id){
        return customerRepository.findById(id);
    }

    public Mono<Customer> findByTitle(String name){
        return customerRepository.findByName(name);
    }

    public Flux<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Mono<Customer> addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }

    public Mono<Customer> updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
