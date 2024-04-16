package com.diegonogueira.contactsapi.controllers.dtos.response;

import com.diegonogueira.contactsapi.controllers.dtos.request.AddressRequest;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

public class ContactResponse {

    private String contactName;
    private String contactEmail;
    private String contactPhone;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private String dateOfBirth;

    private List<AddressRequest> addressRequestList;
}
