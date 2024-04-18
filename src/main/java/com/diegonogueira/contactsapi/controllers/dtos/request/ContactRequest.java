package com.diegonogueira.contactsapi.controllers.dtos.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ContactRequest {

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

    @NotNull(message = "Endereço Obrigatório!")
    private List<AddressRequest> addressRequestList;
}
