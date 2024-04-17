package com.diegonogueira.contactsapi.controllers.dtos.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {


    private String street;
    private Long number;
    private String cep;


}
