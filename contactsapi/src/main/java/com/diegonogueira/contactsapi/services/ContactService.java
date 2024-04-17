package com.diegonogueira.contactsapi.services;

import com.diegonogueira.contactsapi.controllers.dtos.request.ContactRequest;
import com.diegonogueira.contactsapi.controllers.dtos.response.ContactResponse;
import com.diegonogueira.contactsapi.entity.contact.ContactsEntity;
import com.diegonogueira.contactsapi.exeptions.BusinessException;
import com.diegonogueira.contactsapi.exeptions.UnprocessableEntityException;
import com.diegonogueira.contactsapi.mappers.ContactsMapper;
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
    private ContactsMapper contactsMapper;

    public ContactResponse createCandidate(ContactRequest contactRequest){
        ContactsEntity contactsEntity = contactsMapper.mapAddressToRequest(contactRequest);
        contactsEntity = contactRepository.save(contactsEntity);
        return contactsMapper.mapContactsToResponse(contactsEntity);
    }


    public List<ContactResponse> getAllCandidatesWithStacks() {
        List<ContactsEntity> contactsEntities = contactRepository.findAll();
        return contactsEntities.stream()
                .map(contactsMapper::mapContactsToResponse)
                .collect(Collectors.toList());
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





}


