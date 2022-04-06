package com.crowninteractive.customerdatabase.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private String firstName;

    private String lastName;

    @Email
    private String email;
}
