package com.diegonogueira.contactsapi.entity.adress;


import com.diegonogueira.contactsapi.entity.contact.ContactsEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address_tb")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private Long addressId;


    @Column(name = "street")
    private String street;

    @Column(name = "cep")
    private String cep;

    @Column(name = "number")
    private Long number;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private ContactsEntity contactsEntity;
}

