package com.crowninteractive.customerdatabase.data.repository;

import com.crowninteractive.customerdatabase.data.model.BillingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingDetailRepository extends JpaRepository<BillingDetail, Long> {
    @Query("select detail from BillingDetail detail where detail.customer.id = ?1")
    List<BillingDetail> findAllByCustomerId(Long customerId);
}
