-- Adiciona a coluna contact_id na tabela address_tb
ALTER TABLE address_tb
ADD COLUMN contact_id BIGINT,
ADD CONSTRAINT FK_address_contact
FOREIGN KEY (contact_id) REFERENCES contacts_tb(contact_id) ON DELETE CASCADE;

