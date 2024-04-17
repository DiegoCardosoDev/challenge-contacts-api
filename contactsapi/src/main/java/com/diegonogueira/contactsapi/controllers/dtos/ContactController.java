package com.diegonogueira.contactsapi.controllers.dtos;

import com.diegonogueira.contactsapi.controllers.dtos.request.ContactRequest;
import com.diegonogueira.contactsapi.controllers.dtos.response.ContactResponse;
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


    @PostMapping ("/save")
    public ResponseEntity<ContactResponse> createTechnologyStack(@RequestBody  ContactRequest contactRequest) {
        ContactResponse createdTechnologyStack = contactService.createCandidate(contactRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTechnologyStack);
    }

    @GetMapping("/detail/list")
    public List<ContactResponse> getAllCandidatesWithStacks() {
        return contactService.getAllCandidatesWithStacks();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        this.contactService.deleteContact(id);
    }




}
