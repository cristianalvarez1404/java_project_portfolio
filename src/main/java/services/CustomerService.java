package services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import models.Customer;
import org.springframework.stereotype.Service;
import repositories.CustomerRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService{
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
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
