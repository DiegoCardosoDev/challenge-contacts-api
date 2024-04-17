package com.diegonogueira.contactsapi.mappers;


import com.diegonogueira.contactsapi.controllers.dtos.request.ContactRequest;
import com.diegonogueira.contactsapi.controllers.dtos.response.AddressResponse;
import com.diegonogueira.contactsapi.controllers.dtos.response.ContactResponse;
import com.diegonogueira.contactsapi.entity.adress.AddressEntity;
import com.diegonogueira.contactsapi.entity.contact.ContactsEntity;
import com.diegonogueira.contactsapi.repository.AddressRepository;
import com.diegonogueira.contactsapi.repository.ContactsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContactsMapper {

    @Autowired
    private ContactsRepository contactsRepository;

    @Autowired
    private AddressRepository addressRepository;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ContactResponse mapContactsToResponse(ContactsEntity contactsEntity) {
        ContactResponse contactResponse = new ContactResponse();

        contactResponse.setContactName(contactsEntity.getContactName());
        contactResponse.setContactEmail(contactsEntity.getContactEmail());
        contactResponse.setContactPhone(contactsEntity.getContactPhone());
        contactResponse.setDateOfBirth(contactsEntity.getDateOfBirth());

        List<AddressResponse> addressResponseList = contactsEntity.getAddresses().stream()
                .map(stack -> {
                    AddressResponse response = new AddressResponse();
                    response.setStreet(stack.getStreet());
                    response.setNumber(stack.getNumber());
                    response.setCep(stack.getCep());
                    return response;
                })
                .collect(Collectors.toList());
        contactResponse.setAddressRequestList(addressResponseList);

        return contactResponse;
    }

    public ContactsEntity mapAddressToRequest(ContactRequest contactRequest){

        ContactsEntity contactsEntity = new ContactsEntity();
        contactsEntity.setContactName(contactRequest.getContactName());
        contactsEntity.setContactEmail(contactRequest.getContactEmail());
        contactsEntity.setContactPhone(contactRequest.getContactPhone());
        contactsEntity.setDateOfBirth(contactRequest.getDateOfBirth());

        List<AddressEntity> addressEntityList = contactRequest.getAddressRequestList().stream()
                .map(addressRequest -> {
                    AddressEntity addressEntity = new AddressEntity();
                    addressEntity.setStreet(addressRequest.getStreet());
                    addressEntity.setCep(addressRequest.getCep());
                    addressEntity.setNumber(addressRequest.getNumber());
                    return addressRepository.save(addressEntity);
                }).collect(Collectors.toList());
        contactsEntity.setAddresses(addressEntityList);
        contactsEntity = contactsRepository.save(contactsEntity);
        return contactsEntity;

    }
}
