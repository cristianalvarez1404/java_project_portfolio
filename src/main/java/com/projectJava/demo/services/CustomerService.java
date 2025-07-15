package com.projectJava.demo.services;

import com.projectJava.demo.exceptions.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import com.projectJava.demo.models.Customer;
import org.springframework.stereotype.Service;
import com.projectJava.demo.repositories.CustomerRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService{
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = customerRepository.findAll();

        if(customers.isEmpty()){
            throw new CustomerNotFoundException("No customers found");
        }
        return customers;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(()-> new RuntimeException("There is not customer"));
    }

    @Override
    public List<Customer> getCustomersAffiliated() {
        return List.of();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer updateCustomerById(Long id, Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomerById(Long id) {

    }
}
