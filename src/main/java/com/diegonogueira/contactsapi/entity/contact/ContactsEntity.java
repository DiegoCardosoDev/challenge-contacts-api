package com.diegonogueira.contactsapi.entity.contact;

import com.diegonogueira.contactsapi.entity.adress.AddressEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contacts_tb")
public class ContactsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long contactId;


    @Column(name = "contact_name")
    private String contactName;
    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "contact_address",
            joinColumns = @JoinColumn(name = "contact_id", referencedColumnName = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<AddressEntity> addresses;
}
