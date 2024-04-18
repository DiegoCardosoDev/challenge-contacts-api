CREATE TABLE contact_address (
    contact_id BIGINT,
    address_id BIGINT,
    PRIMARY KEY (contact_id, address_id),
    FOREIGN KEY (contact_id) REFERENCES contacts_tb(contact_id) ON DELETE CASCADE,
    FOREIGN KEY (address_id) REFERENCES address_tb(address_id) ON DELETE CASCADE
);
