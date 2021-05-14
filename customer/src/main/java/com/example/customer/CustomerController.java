package com.example.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path="/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

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

    @PostMapping("/add")
    public Mono<Customer> addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @DeleteMapping("/delete/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customer) {
        customerService.deleteCustomer(customer);
    }

    @PutMapping("/update")
    public Mono<Customer> updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }
}
