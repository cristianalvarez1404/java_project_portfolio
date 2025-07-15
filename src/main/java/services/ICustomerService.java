package services;

import models.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getCustomers();
    Customer getCustomerById(Long id);
    List<Customer> getCustomersAffiliated();
    Customer createCustomer(Customer customer);
    Customer updateCustomerById(Long id,Customer customer);
    void deleteCustomerById(Long id);
}
