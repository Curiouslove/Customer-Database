package com.crowninteractive.customerdatabase;

import com.crowninteractive.customerdatabase.data.model.BillingDetail;
import com.crowninteractive.customerdatabase.data.model.Customer;
import com.crowninteractive.customerdatabase.data.repository.BillingDetailRepository;
import com.crowninteractive.customerdatabase.data.repository.CustomerRepository;
import com.crowninteractive.customerdatabase.dto.request.CustomerDto;
import com.crowninteractive.customerdatabase.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerDatabaseServiceTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BillingDetailRepository billingDetailRepository;


    private Customer customer;

    @BeforeEach
    void setUp() {
        billingDetailRepository.deleteAll();
        customerRepository.deleteAll();

        customerRepository.save(Customer.builder().firstName("love").lastName("okum").emailAddress("lovieokum@gmail.com").build());
        customerRepository.save(Customer.builder().firstName("lovie").lastName("collins").emailAddress("collinslove624@yahoo.com").build());
        customerRepository.save(Customer.builder().firstName("ike").lastName("odez").emailAddress("ikeodez@gmail.com").build());
        customerRepository.save(Customer.builder().firstName("eme").lastName("anya").emailAddress("anyae@gmail.com").build());
        customerRepository.save(Customer.builder().firstName("sanni").lastName("idris").emailAddress("sannii@gmail.com").build());

 customer = customerRepository.findById(customerRepository.findCustomerByEmailAddress("lovieokum@gmail.com").getId()).get();
  Customer nextCustomer = customerRepository.findById(customerRepository.findCustomerByEmailAddress("anyae@gmail.com").getId()).get();

        billingDetailRepository.save(BillingDetail.builder().customer(customer).accountNumber("0123456789").tariff(new BigDecimal(200)).build());
        billingDetailRepository.save(BillingDetail.builder().customer(customer).accountNumber("1234567890").tariff(new BigDecimal(200)).build());
        billingDetailRepository.save(BillingDetail.builder().customer(nextCustomer).accountNumber("2345678901").tariff(new BigDecimal(200)).build());
        billingDetailRepository.save(BillingDetail.builder().customer(customer).accountNumber("3456789012").tariff(new BigDecimal(200)).build());
        billingDetailRepository.save(BillingDetail.builder().customer(nextCustomer).accountNumber("4567890123").tariff(new BigDecimal(200)).build());
    }

    @Test
    void findAll() {
        assertThat(customerRepository.findAll()).hasSize(5);
        List<Customer> customerList= customerService.getAllCustomers();

        assertThat(customerList).isNotNull();

        assertEquals(5, customerList.size());

    }

    @Test
    void save() {
        CustomerDto customerRequest = new CustomerDto();
        customerRequest.setFirstName("lovely");
        customerRequest.setLastName("love");
        customerRequest.setEmail("loving@gmail.com");

        // given
        assertThat(customerRepository.findAll()).hasSize(5);

        // when
        customerService.saveACustomer(customerRequest);

        // assert
        assertThat(customerRepository.findAll()).hasSize(6);
    }


    @Test
    void saveThrowsOnInvalidEmail() {
        CustomerDto customerRequest = new CustomerDto();
        customerRequest.setFirstName("lekan");
        customerRequest.setLastName("Lastly");
        customerRequest.setEmail("email");

        assertThrows(ConstraintViolationException.class, () -> customerService.saveACustomer(customerRequest));
    }

    @Test
    void findById() {
        Customer foundCustomer = customerService.getACustomer(customer.getId());

        assertThat(foundCustomer).isNotNull();
        assertThat(foundCustomer.getEmailAddress().equalsIgnoreCase(customerService.getACustomer(customer.getId()).getEmailAddress()));
    }
}
