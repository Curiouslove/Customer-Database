package com.crowninteractive.customerdatabase.dto.request;

import com.crowninteractive.customerdatabase.configuration.PriceConfiguration;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingDetailDto {

    @Pattern(regexp = "[0-9]{10}")
    private String accountNumber;

    @JsonSerialize(using = PriceConfiguration.class)
    private BigDecimal tariff;
}
