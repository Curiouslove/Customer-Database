package com.crowninteractive.customerdatabase.data.repository;

import com.crowninteractive.customerdatabase.data.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByEmailAddress(String email);
}
