package com.diegonogueira.contactsapi.repository;

import com.diegonogueira.contactsapi.entity.contact.ContactsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends JpaRepository<ContactsEntity, Long> {

    boolean existsByContactEmail(String contactEmail);
    boolean existsByContactPhone(String contactPhone);

    List<ContactsEntity> findByContactNameContainingIgnoreCase(String contactName);
}
