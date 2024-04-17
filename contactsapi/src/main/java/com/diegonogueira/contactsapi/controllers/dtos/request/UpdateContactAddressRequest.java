package com.diegonogueira.contactsapi.controllers.dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateContactAddressRequest {


    private String contactName;
    private String contactEmail;
    private String contactPhone;
    private LocalDate dateOfBirth;

    private Long addressId;
    private String street;
    private String cep;
    private Long number;
    private Boolean active;
}
