package com.diegonogueira.contactsapi.entity.adress;


import com.diegonogueira.contactsapi.entity.contact.ContactsEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address_tb")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;


    @Column(name = "street")
    private String street;

    @Column(name = "cep")
    private String cep;

    @Column(name = "number")
    private Long number;

    @ManyToMany(mappedBy = "addresses")
    private List<ContactsEntity> contacts;


}

