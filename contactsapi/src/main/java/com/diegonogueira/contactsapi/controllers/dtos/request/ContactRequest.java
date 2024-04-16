package com.diegonogueira.contactsapi.controllers.dtos.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ContactRequest {

    private String contactName;
    private String contactEmail;
    private String contactPhone;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private String dateOfBirth;

    private List<AddressRequest> addressRequestList;
}
