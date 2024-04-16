package com.diegonogueira.contactsapi.controllers.dtos.response;

import com.diegonogueira.contactsapi.controllers.dtos.request.AddressRequest;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

public class AddressResponse {

    private String street;
    private String cep;
    private String number;
}
