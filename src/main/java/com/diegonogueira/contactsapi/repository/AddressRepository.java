package com.diegonogueira.contactsapi.repository;

import com.diegonogueira.contactsapi.entity.adress.AddressEntity;
import com.diegonogueira.contactsapi.entity.contact.ContactsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
