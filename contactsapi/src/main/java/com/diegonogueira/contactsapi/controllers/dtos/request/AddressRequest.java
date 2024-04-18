package com.diegonogueira.contactsapi.controllers.dtos.request;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {


    private Long addressId;

    @NotBlank(message = "Nome da rua Obrigatório!")
    private String street;

    @NotNull(message = "Número Obrigatório!")
    private Long number;

    @NotBlank(message = "Cep é obrigatório!, exemplo: 12345-678 ou 12345678")
    private String cep;


    private Boolean active;


}
