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
        return customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("There is not customer"));
    }

    @Override
    public List<Customer> getCustomersAffiliated() {
        return customerRepository.findByAffiliatedTrue();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomerById(Long id, Customer customer) {
        return customerRepository.findById(id)
                .map((customerToUpdate) -> {
                    customerToUpdate.setFirstName(customer.getFirstName());
                    customerToUpdate.setLastName(customer.getLastName());
                    customerToUpdate.setAddress(customer.getAddress());
                    customerToUpdate.setEmail(customer.getEmail());
                    customerToUpdate.setAge(customer.getAge());
                    customerToUpdate.setAffiliated(customer.getAffiliated());
                    return customerToUpdate;
                }).orElse(null);
    }

    @Override
    public String deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
        return "Customer deleted successfully";
    }
}
