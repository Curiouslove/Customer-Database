package com.crowninteractive.customerdatabase.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BillingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String accountNumber;

    private BigDecimal tariff;

    @PrePersist
    public void updateAccountNumberWithExtension(){
        this.accountNumber = accountNumber + "-01";
    }

}
