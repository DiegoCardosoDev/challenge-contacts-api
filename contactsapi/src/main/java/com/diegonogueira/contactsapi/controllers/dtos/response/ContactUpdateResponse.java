package com.diegonogueira.contactsapi.controllers.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ContactUpdateResponse {

    private String contactName;
    private String contactEmail;
    private String contactPhone;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;

    private Long addressId;
    private String street;
    private String cep;
    private Long number;
    private Boolean active;


}
