CREATE TABLE contacts_tb (

    contact_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    contact_name VARCHAR(255) NOT NULL,
    contact_email VARCHAR(255) NOT NULL UNIQUE,
    contact_phone VARCHAR(20),
    date_of_birth DATE
);

