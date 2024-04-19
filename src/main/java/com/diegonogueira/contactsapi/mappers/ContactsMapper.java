package com.diegonogueira.contactsapi.mappers;


import com.diegonogueira.contactsapi.controllers.dtos.request.ContactRequest;
import com.diegonogueira.contactsapi.controllers.dtos.response.AddressResponse;
import com.diegonogueira.contactsapi.controllers.dtos.response.ContactResponse;
import com.diegonogueira.contactsapi.controllers.dtos.response.ContactUpdateResponse;
import com.diegonogueira.contactsapi.entity.adress.AddressEntity;
import com.diegonogueira.contactsapi.entity.contact.ContactsEntity;
import com.diegonogueira.contactsapi.exceptions.UnprocessableEntityException;
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

    public ContactResponse mapContactsToResponse(ContactsEntity contactsEntity) {
        ContactResponse contactResponse = new ContactResponse();

        contactResponse.setContactId(contactsEntity.getContactId());
        contactResponse.setContactName(contactsEntity.getContactName());
        contactResponse.setContactEmail(contactsEntity.getContactEmail());
        contactResponse.setContactPhone(contactsEntity.getContactPhone());
        contactResponse.setDateOfBirth(contactsEntity.getDateOfBirth());

        List<AddressResponse> addressResponseList = contactsEntity.getAddresses().stream()
                .map(addressEntity -> {
                    AddressResponse response = new AddressResponse();
                    response.setAddressId(addressEntity.getAddressId());
                    response.setStreet(addressEntity.getStreet());
                    response.setNumber(addressEntity.getNumber());
                    response.setCep(addressEntity.getCep());
                    response.setActive(addressEntity.getActive());
                    return response;
                })
                .collect(Collectors.toList());
        contactResponse.setAddressRequestList(addressResponseList);

        return contactResponse;
    }

    public ContactsEntity mapAddressToRequest(ContactRequest contactRequest){

        if (contactsRepository.existsByContactEmail(contactRequest.getContactEmail())) {
            throw new IllegalArgumentException("E-mail já está em uso");
        }
        if (contactsRepository.existsByContactPhone(contactRequest.getContactPhone())) {
            throw new IllegalArgumentException("Telefone já existente");
        }
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
                    addressEntity.setActive(addressRequest.getActive());
                    return addressRepository.save(addressEntity);
                }).collect(Collectors.toList());
        contactsEntity.setAddresses(addressEntityList);
        contactsEntity = contactsRepository.save(contactsEntity);
        return contactsEntity;

    }
    public ContactUpdateResponse mapContactToUpdateResponse(ContactsEntity contactsEntity, Long addressId) {
        ContactUpdateResponse contactResponse = new ContactUpdateResponse();

        contactResponse.setContactId(contactsEntity.getContactId());
        contactResponse.setContactName(contactsEntity.getContactName());
        contactResponse.setContactEmail(contactsEntity.getContactEmail());
        contactResponse.setContactPhone(contactsEntity.getContactPhone());
        contactResponse.setDateOfBirth(contactsEntity.getDateOfBirth());

        // Buscar o endereço atualizado pelo ID
        AddressEntity updatedAddress = contactsEntity.getAddresses().stream()
                .filter(address -> address.getAddressId().equals(addressId))
                .findFirst()
                .orElseThrow(() -> new UnprocessableEntityException("Address not found with id: " + addressId));

        contactResponse.setAddressId(updatedAddress.getAddressId());
        contactResponse.setStreet(updatedAddress.getStreet());
        contactResponse.setCep(updatedAddress.getCep());
        contactResponse.setNumber(updatedAddress.getNumber());
        contactResponse.setActive(updatedAddress.getActive());

        return contactResponse;
    }




}
