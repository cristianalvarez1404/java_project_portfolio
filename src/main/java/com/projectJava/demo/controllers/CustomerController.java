package com.projectJava.demo.controllers;

import com.projectJava.demo.exceptions.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import com.projectJava.demo.models.Customer;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projectJava.demo.services.ICustomerService;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class CustomerController {
    private final ICustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers(){
        try {
            List<Customer> customers = customerService.getCustomers();
            return ResponseEntity.ok(customers);
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        try {
            Customer customer = customerService.getCustomerById(id);
            return ResponseEntity.ok(customer);
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/customers/affiliated")
    public ResponseEntity<List<Customer>> getCustomerByAffiliated(){
        try {
            List<Customer> customers = customerService.getCustomersAffiliated();
            return ResponseEntity.ok(customers);
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        try {
            Customer newCustomer = customerService.createCustomer(customer);
            return ResponseEntity.ok(newCustomer);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        try{
            Customer customerUpdated = customerService.updateCustomerById(id,customer);
            return ResponseEntity.ok(customerUpdated);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        try{
            String customerDeleted = customerService.deleteCustomerById(id);
            return ResponseEntity.ok(customerDeleted);
        }catch (CustomerNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
