package com.diegonogueira.contactsapi.mappers;


import com.diegonogueira.contactsapi.controllers.dtos.request.AddressRequest;
import com.diegonogueira.contactsapi.controllers.dtos.response.AddressResponse;
import com.diegonogueira.contactsapi.entity.adress.AddressEntity;
import com.diegonogueira.contactsapi.repository.ContactsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AddressMapper {

    private ContactsRepository contactsRepository;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public AddressResponse mapAddressToResponse(AddressEntity addressEntity) {
        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setStreet(addressEntity.getStreet());
        addressResponse.setCep(addressEntity.getCep());
        addressResponse.setNumber(addressEntity.getNumber());
        return addressResponse;
    }

    public AddressEntity mapAddressToRequest(AddressRequest addressRequest){

        return new AddressEntity();

    }
}
