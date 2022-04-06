package com.crowninteractive.customerdatabase.data.repository;

import com.crowninteractive.customerdatabase.data.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
