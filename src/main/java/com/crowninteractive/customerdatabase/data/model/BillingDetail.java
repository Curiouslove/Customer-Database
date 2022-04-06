package com.crowninteractive.customerdatabase.data.model;

import com.crowninteractive.customerdatabase.configuration.PriceConfiguration;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String accountNumber;

    @JsonSerialize(using = PriceConfiguration.class)
    private BigDecimal tariff;

    @ManyToOne
    private Customer customer;

    @PrePersist
    public void updateAccountNumberWithExtension(){
        this.accountNumber = accountNumber + "-01";
    }

}
