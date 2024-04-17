package com.diegonogueira.contactsapi.controllers.dtos;

import com.diegonogueira.contactsapi.controllers.dtos.request.ContactRequest;
import com.diegonogueira.contactsapi.controllers.dtos.request.UpdateContactAddressRequest;
import com.diegonogueira.contactsapi.controllers.dtos.response.ContactResponse;
import com.diegonogueira.contactsapi.controllers.dtos.response.ContactUpdateResponse;
import com.diegonogueira.contactsapi.entity.contact.ContactsEntity;
import com.diegonogueira.contactsapi.mappers.ContactsMapper;
import com.diegonogueira.contactsapi.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/contact", produces = {"application/json"})
@RequiredArgsConstructor
public class ContactController {

    private final ContactService  contactService;
    private final ContactsMapper contactsMapper;


    @PostMapping ("/save")
    public ResponseEntity<ContactResponse> createTechnologyStack(@RequestBody  ContactRequest contactRequest) {
        ContactResponse createdTechnologyStack = contactService.createCandidate(contactRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTechnologyStack);
    }

    @GetMapping("/list")
    public List<ContactResponse> getAllCandidatesWithStacks() {
        return contactService.getAllContactsWithAddress();
    }

    @GetMapping("/search/{id}")
    public ContactResponse getById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        this.contactService.deleteContact(id);
    }

    @PutMapping("/update/{contactId}/address/{addressId}")
    public ResponseEntity<ContactUpdateResponse> updateContact(@PathVariable Long contactId, @PathVariable Long addressId,
                                                               @RequestBody UpdateContactAddressRequest request) {
        ContactsEntity updatedContact = contactService.updateContactAndAddress(contactId, addressId, request);
        ContactUpdateResponse response = contactsMapper.mapContactToUpdateResponse(updatedContact, addressId);
        return ResponseEntity.ok(response);
    }







}
