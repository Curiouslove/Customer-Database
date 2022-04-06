package com.crowninteractive.customerdatabase.controller;

import com.crowninteractive.customerdatabase.data.model.Customer;
import com.crowninteractive.customerdatabase.dto.request.CustomerDto;
import com.crowninteractive.customerdatabase.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class CustomerDatabaseController {
    private final CustomerService customerService;

    @GetMapping("customers")
    public ResponseEntity<?> getAllCustomers(){
        List<Customer> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<?> getACustomer(@PathVariable Long id){
        Customer customer = customerService.getACustomer(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PostMapping("customer")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDto customerDto){
        customerService.saveACustomer(customerDto);
        return new ResponseEntity<>("Customer has been saved to the database", HttpStatus.CREATED);
    }
}
