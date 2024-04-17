package com.diegonogueira.contactsapi.controllers.dtos.response;

import com.diegonogueira.contactsapi.controllers.dtos.request.AddressRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class AddressResponse {

    private String street;
    private String cep;
    private Long number;
    private Boolean active;

}
