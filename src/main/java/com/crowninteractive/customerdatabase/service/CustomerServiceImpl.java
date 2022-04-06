package com.crowninteractive.customerdatabase.service;

import com.crowninteractive.customerdatabase.data.model.Customer;
import com.crowninteractive.customerdatabase.data.repository.CustomerRepository;
import com.crowninteractive.customerdatabase.dto.request.CustomerDto;
import com.crowninteractive.customerdatabase.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getACustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()){
            return customer.get();
        }
        else {
            throw new ResourceNotFoundException("Customer", "id", String.valueOf(id));
        }
    }

    @Override
    public void saveACustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmailAddress(customerDto.getEmail());

        customerRepository.save(customer);
    }
}
