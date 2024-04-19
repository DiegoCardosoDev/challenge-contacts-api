package com.diegonogueira.contactsapi.services;

import com.diegonogueira.contactsapi.controllers.dtos.request.ContactRequest;
import com.diegonogueira.contactsapi.controllers.dtos.request.UpdateContactAddressRequest;
import com.diegonogueira.contactsapi.controllers.dtos.response.ContactResponse;
import com.diegonogueira.contactsapi.entity.adress.AddressEntity;
import com.diegonogueira.contactsapi.entity.contact.ContactsEntity;
import com.diegonogueira.contactsapi.exceptions.BusinessException;
import com.diegonogueira.contactsapi.exceptions.EmailAlreadyExistsException;
import com.diegonogueira.contactsapi.exceptions.PhoneAlreadyExistsException;
import com.diegonogueira.contactsapi.exceptions.UnprocessableEntityException;
import com.diegonogueira.contactsapi.mappers.ContactsMapper;
import com.diegonogueira.contactsapi.repository.AddressRepository;
import com.diegonogueira.contactsapi.repository.ContactsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;


@Service
@RequiredArgsConstructor
public class ContactService {


    @Autowired
    private ContactsRepository contactRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ContactsMapper contactsMapper;

    public ContactResponse createCandidate(ContactRequest contactRequest){
        ContactsEntity contactsEntity = contactsMapper.mapAddressToRequest(contactRequest);
        contactsEntity = contactRepository.save(contactsEntity);
        return contactsMapper.mapContactsToResponse(contactsEntity);
    }


    public List<ContactResponse> getAllContactsWithAddress() {
        List<ContactsEntity> contactsEntities = contactRepository.findAll();
        return contactsEntities.stream()
                .map(contactsMapper::mapContactsToResponse)
                .collect(Collectors.toList());
    }

    public ContactResponse getContactById(Long id){
        try{
            ContactsEntity candidateEntity = contactRepository.findById(id)
                    .orElseThrow(() -> new UnprocessableEntityException("Contact not found with id: " + id));
            return contactsMapper.mapContactsToResponse(candidateEntity);
        }catch ( Exception e ){
            throw new BusinessException(format("Error search Contact  with id: " + id),e);
        }

    }

    public void deleteContact(Long id){
        try{
            if ( !contactRepository.existsById(id) ) {
                throw new UnprocessableEntityException("Contact not found with id: " + id);
            }else {
                contactRepository.deleteById(id);
            }
        }catch ( Exception e  ){
            throw new BusinessException(format("Error delete Contact  with id: " + id),e);
        }
    }


    public ContactsEntity updateContactAndAddress(Long contactId, Long addressId, UpdateContactAddressRequest request) {
        ContactsEntity existingContact = contactRepository.findById(contactId)
                .orElseThrow(() -> new UnprocessableEntityException("Contact not found with id: " + contactId));


        if (contactRepository.existsByContactEmailAndIdNot(request.getContactEmail(), contactId)) {
            throw new EmailAlreadyExistsException("Email is already in use");
        }

        if (contactRepository.existsByContactPhoneAndIdNot(request.getContactPhone(), contactId)) {
            throw new PhoneAlreadyExistsException("Phone is already in use");
        }

        existingContact.setContactName(request.getContactName());
        existingContact.setContactEmail(request.getContactEmail());
        existingContact.setContactPhone(request.getContactPhone());
        existingContact.setDateOfBirth(request.getDateOfBirth());

        AddressEntity existingAddress = existingContact.getAddresses().stream()
                .filter(address -> address.getAddressId().equals(addressId))
                .findFirst()
                .orElseThrow(() -> new UnprocessableEntityException("Address not found with id: " + addressId));

        existingAddress.setStreet(request.getStreet());
        existingAddress.setCep(request.getCep());
        existingAddress.setNumber(request.getNumber());
        existingAddress.setActive(request.getActive());

        return contactRepository.save(existingContact);
    }

    public List<ContactResponse> getContactByName(String name){

        try {
            List<ContactsEntity> candidates = contactRepository.findByContactNameContainingIgnoreCase(name);
            if(candidates.isEmpty()){
                throw new UnprocessableEntityException("not found with name{}"+ name);
            }
            return candidates.stream()
                    .map(contactsMapper::mapContactsToResponse)
                    .collect(Collectors.toList());
        }catch ( Exception e ){
            throw new BusinessException(format("not found contact with name = %s",name),e);
        }
    }

}


