CREATE TABLE address_tb (
    address_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    number BIGINT
);