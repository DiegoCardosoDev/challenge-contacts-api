package com.diegonogueira.contactsapi.repository;

import com.diegonogueira.contactsapi.entity.contact.ContactsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends JpaRepository<ContactsEntity, Long> {

    boolean existsByContactEmail(String contactEmail);
    boolean existsByContactPhone(String contactPhone);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM ContactsEntity c WHERE c.contactEmail = :email AND c.contactId <> :id")
    boolean existsByContactEmailAndIdNot(@Param("email") String email, @Param("id") Long id);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM ContactsEntity c WHERE c.contactPhone = :phone AND c.contactId <> :id")
    boolean existsByContactPhoneAndIdNot(@Param("phone") String phone, @Param("id") Long id);



    List<ContactsEntity> findByContactNameContainingIgnoreCase(String contactName);
}
