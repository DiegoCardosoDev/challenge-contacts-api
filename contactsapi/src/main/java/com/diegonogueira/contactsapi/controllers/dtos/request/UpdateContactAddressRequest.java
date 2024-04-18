package com.diegonogueira.contactsapi.controllers.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateContactAddressRequest {


    @NotBlank(message = "nome obrigatório")
    @Size(min = 1, max = 255)
    private String contactName;

    @Email(message = "Insira uma email valido!")
    private String contactEmail;

    @NotBlank(message = "Informe telefone para contato!")
    @Size(min = 7, max = 16, message = "O telefone precisa ter entre 7 e 16 caracteres, ex: +55 11 1234-5678")
    private String contactPhone;

    @NotNull(message = "Data de nascimento obrigatório!")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;


    private Long addressId;

    @NotBlank(message = "Nome da rua Obrigatório!")
    private String street;

    @NotBlank(message = "Cep é obrigatório!, exemplo: 12345-678 ou 12345678")
    private String cep;

    @NotNull(message = "Número Obrigatório!")
    private Long number;


    private Boolean active;
}
