package com.crowninteractive.customerdatabase.service;

import com.crowninteractive.customerdatabase.data.model.BillingDetail;
import com.crowninteractive.customerdatabase.data.model.Customer;
import com.crowninteractive.customerdatabase.data.repository.BillingDetailRepository;
import com.crowninteractive.customerdatabase.dto.request.BillingDetailDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BillingDetailServiceImpl implements BillingDetailService{
    private final CustomerService customerService;
    private final BillingDetailRepository billingDetailRepository;

    @Override
    public List<BillingDetail> findBillingDetailsByCustomerId(Long id) {
        return billingDetailRepository.findAllByCustomerId(id);
    }

    @Override
    public void saveBillingDetails(BillingDetailDto billingDetailDto) {
        Customer customer = customerService.getACustomer(billingDetailDto.getCustomerId());

        BillingDetail billingDetail = new BillingDetail();
        billingDetail.setCustomer(customer);
        billingDetail.setAccountNumber(billingDetailDto.getAccountNumber());
        billingDetail.setTariff(billingDetailDto.getTariff());

        billingDetailRepository.save(billingDetail);

    }

   
}
