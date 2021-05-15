package com.example.customer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path="/api/customer")
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @GetMapping
    public Flux<Customer> getCustomers(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> getCustomer(@PathVariable("id") Integer id) {
        return customerService.findById(id);
    }

    @GetMapping("/search/{title}")
    public Mono<Customer> searchCustomer(@PathVariable("title") String title) {
        return customerService.findByTitle(title);
    }

    @PostMapping("")
    public Mono<Customer> addCustomer(@RequestBody Customer customer) {
        if(customer.getAge() > 0 && customer.getAge() < 13) {
            customer.setCategory("Enfant");
        } else if(customer.getAge() >= 13 && customer.getAge() < 18) {
            customer.setCategory("Ado");
        } else if(customer.getAge() >= 18) {
            customer.setCategory("adulte");
        } else {
            throw new RuntimeException("Wrong age");
        }
        return customerService.addCustomer(customer);
    }

    @DeleteMapping("/{customerId}")
    public Mono<Void> deleteCustomer(@PathVariable("customerId") int customerId) {
        return customerService.deleteCustomer(customerId);
    }

    @PutMapping("")
    public Mono<Customer> updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }
}
