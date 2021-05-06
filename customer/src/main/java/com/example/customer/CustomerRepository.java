package com.example.customer;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import reactor.core.publisher.Mono;

@RepositoryRestResource(path="customer")
public interface CustomerRepository extends ReactiveCrudRepository<Customer, Integer> {
    Mono<Customer> findByName(String name);
    Mono<Customer> findByLogin(String name);
}
