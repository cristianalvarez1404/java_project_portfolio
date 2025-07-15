package com.projectJava.demo.controllers;

import com.projectJava.demo.exceptions.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import com.projectJava.demo.models.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
