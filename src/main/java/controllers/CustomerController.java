package controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import models.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import services.ICustomerService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class CustomerController {
    private final ICustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok(customerService.getCustomers());
    }
}
