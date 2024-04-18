CREATE TABLE address_tb (
    address_id BIGSERIAL PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    number BIGINT,
    active BOOLEAN NOT NULL DEFAULT TRUE
);
