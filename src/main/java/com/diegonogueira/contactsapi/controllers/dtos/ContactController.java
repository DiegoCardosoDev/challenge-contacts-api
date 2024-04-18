package com.diegonogueira.contactsapi.controllers.dtos;

import com.diegonogueira.contactsapi.controllers.dtos.request.ContactRequest;
import com.diegonogueira.contactsapi.controllers.dtos.request.UpdateContactAddressRequest;
import com.diegonogueira.contactsapi.controllers.dtos.response.ContactResponse;
import com.diegonogueira.contactsapi.controllers.dtos.response.ContactUpdateResponse;
import com.diegonogueira.contactsapi.entity.contact.ContactsEntity;
import com.diegonogueira.contactsapi.mappers.ContactsMapper;
import com.diegonogueira.contactsapi.services.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/contact", produces = {"application/json"})
@Tag(name = "Contacts-Api")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService  contactService;
    private final ContactsMapper contactsMapper;


    @Operation(summary = "Realiza A criação de contatos", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "contatos criado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao criar contato"),
    })
    @PostMapping (value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ContactResponse> createTechnologyStack(@RequestBody @Valid  ContactRequest contactRequest) {
        ContactResponse createdTechnologyStack = contactService.createCandidate(contactRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTechnologyStack);
    }


    @Operation(summary = "Realiza A bussca de contatos", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca de contatos realizada com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a Busca dos contatos"),
    })
    @GetMapping(value = "/list")
    public List<ContactResponse> getAllCandidatesWithStacks() {
        return contactService.getAllContactsWithAddress();
    }

    @Operation(summary = "Realiza A busca de contato por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca de contato realizada com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a Busca do contato"),
            @ApiResponse(responseCode = "422", description = "erro ao buscar o contato com id informado"),
    })
    @GetMapping(value = "/search/{id}")
    public ContactResponse getById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }




    @Operation(summary = "Realiza A busca de contato por Nome", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca de contato realizada com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar a Busca do contato"),
            @ApiResponse(responseCode = "422", description = "erro ao buscar o contato com nome informado"),
    })
    @GetMapping("/search-name")
    public List<ContactResponse> getContactByName(@RequestParam String name) {
        return contactService.getContactByName(name);
    }

    @Operation(summary = "Deleta o contato por ID", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contato deletado com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar o contato"),
            @ApiResponse(responseCode = "422", description = "erro ao deletar o contato com id informado"),

    })
    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        this.contactService.deleteContact(id);
    }

    @Operation(summary = "Atualiza o contato por ID", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Contato atualizado com sucesso!"),
            @ApiResponse(responseCode = "500", description = "Erro ao atualizar o contato"),
            @ApiResponse(responseCode = "422", description = "erro ao atualizar o contato com id informado"),

    })
    @PutMapping("/update/{contactId}/address/{addressId}")
    public ResponseEntity<ContactUpdateResponse> updateContact(@PathVariable Long contactId, @PathVariable Long addressId,
                                                               @RequestBody @Valid UpdateContactAddressRequest request) {
        ContactsEntity updatedContact = contactService.updateContactAndAddress(contactId, addressId, request);
        ContactUpdateResponse response = contactsMapper.mapContactToUpdateResponse(updatedContact, addressId);
        return ResponseEntity.ok(response);
    }







}
