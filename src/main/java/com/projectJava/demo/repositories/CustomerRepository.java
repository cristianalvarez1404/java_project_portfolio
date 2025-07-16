package com.projectJava.demo.repositories;

import com.projectJava.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByAffiliatedTrue();
}
