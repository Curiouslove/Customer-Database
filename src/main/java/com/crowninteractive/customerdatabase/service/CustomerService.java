package com.crowninteractive.customerdatabase.service;

import com.crowninteractive.customerdatabase.data.model.Customer;
import com.crowninteractive.customerdatabase.dto.request.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getACustomer(Long id);
    void saveACustomer(CustomerDto customerDto);
}
