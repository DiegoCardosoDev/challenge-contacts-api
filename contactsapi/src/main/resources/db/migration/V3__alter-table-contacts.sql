-- Adiciona a coluna address_id na tabela contacts_tb com ON DELETE CASCADE
ALTER TABLE contacts_tb
ADD COLUMN address_id BIGINT,
ADD CONSTRAINT FK_contact_address
FOREIGN KEY (address_id) REFERENCES address_tb(addressId) ON DELETE CASCADE;

