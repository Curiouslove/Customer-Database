package com.crowninteractive.customerdatabase.service;

import com.crowninteractive.customerdatabase.data.model.BillingDetail;
import com.crowninteractive.customerdatabase.dto.request.BillingDetailDto;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public interface BillingDetailService {
    List<BillingDetail> findBillingDetailsByCustomerId(Long id);
    void saveBillingDetails(BillingDetailDto billingDetailDto);
}
