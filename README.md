# challenge-contacts-api

<div>
    <div style="display: inline_block"><br>
        <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" />
        <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
        <img src="https://img.shields.io/badge/PostgreSQL-336791?style=for-the-badge&logo=postgresql&logoColor=white" />
        <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white" />
        <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white" />
        <img src="https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black" />
        <img src="https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white" />
    </div>
</div>


  
# API para gestão de contatos


A API tem como objetivo gerenciar contatos, oferecendo funcionalidades para criar, buscar, atualizar e deletar contatos, bem como seus endereços associados.


## Tecnologias usadas:

- Java 17
- Spring Boot
- PostgreSQL 16
- Maven para gerenciamento de dependências
- Swagger para documentação
- Padrão MVC
- Deploy No Render

## Dependências:

- Driver Postgres
- Spring data jpa
- Lombok
- Spring Web
- validation



## Funcionalidades

- **Criar Contato**: Permite criar um novo contato.
  
- **Buscar Todos os Contatos**: Retorna uma lista com todos os contatos cadastrados, incluindo seus respectivos endereços.
  
- **Buscar Contato por ID**: Retorna um contato específico com seus detalhes e lista de endereços.
  
- **Deletar Contato por ID**: Remove um contato específico e seus endereços associados. Ao deletar um contato, todos os seus endereços também são excluídos.

## Detalhes Adicionais

- Um contato pode ter mais de um endereço associado.
  
- Ao buscar ou deletar um contato, os endereços associados a esse contato são retornados ou excluídos, respectivamente.
- o e-mail é unico, não é possivel criar contatos com mesmo email, o mesmo email só permitido na atualização de contato. 
- Para gerenciar múltiplos endereços, foi adicionada uma regra que permite definir um endereço como ativo.





## Execução Local do projeto

- Pode ser acessado pela doc do swagger:  https://challenge-contacts-api-dev-1-1.onrender.com/swagger-ui/index.html#/
- Pode ser testado atarves do [https://www.postman.com/](https://www.postman.com/)
- no repositorio acima tem a collection para usar no postaman: challenge-contacts-api.postman_collection.json, baixe e importe no postman.
- Clone do projeto: `https://github.com/DiegoCardosoDev/challenge-contacts-api.git`


- **Endpoints:**
    
1. **Criar um novo contato (POST)**
   - `https://challenge-contacts-api-dev-1-1.onrender.com/contacts/save`
  
     
     **BODY REQUEST:**
     ```json
     {
       "contactName": "João Silva",
       "contactEmail": "joao.silva@example.com",
       "contactPhone": "+55 11 1234-5678",
       "dateOfBirth": "08/05/1389",
       "addressRequestList": [
         {
           "street": "Rua Teste",
           "cep": "12345-678",
           "number": 123,
           "active": true
         },
         {
           "street": "Avenida Principal",
           "cep": "98765-432",
           "number": 456,
           "active": false
         }
       ]
     }
     ```


2. **Listar Todos Contatos** (GET)
   - `https://challenge-contacts-api-dev-1-1.onrender.com/contacts/list`

3. **Buscar contato por id** (GET)
   - `https://challenge-contacts-api-dev-1-1.onrender.com/contacts/search/{id}`
  
4. **Buscar contato por nome** (GET)
- `https://challenge-contacts-api-dev-1-1.onrender.com/contacts/search-name?name=nome_buscado`
    
5. **Atualizar contato (PUT)**
   - `https://challenge-contacts-api-dev-1-1.onrender.com/contacts//update/{contactId}/address/{addressId}`
     
     **BODY REQUEST:**
       ```json
     {
       "contactName": "João Silva",
       "contactEmail": "joao.silva@example.com",
       "contactPhone": "+55 11 1234-5678",
       "dateOfBirth": "08/05/1389",
       "addressId": 1,
       "street": "Rua Teste",
       "cep": "12345-678",
       "number": 123,
       "active": true   
     }
     




6. **Deletar um contato** (DELETE)
   - `https://challenge-contacts-api-dev-1-1.onrender.com/contacts/delete/{id}`
  





   # Execução do projeto Local 

## 1. Instalação e Configuração do Java 17

- Certifique-se de ter o Java 17 instalado e configurado corretamente em sua máquina.

## 2. Instalação e Configuração do PostgreSQL 16

- Instale o PostgreSQL 16 e configure-o conforme necessário para o seu ambiente.

## 3. Instalação e Configuração do IntelliJ IDEA

- Instale o IntelliJ IDEA, uma IDE popular para desenvolvimento Java.
- Configure o IntelliJ IDEA de acordo com suas preferências e necessidades.

## 4. Clone do Projeto

- Faça o clone do projeto para sua máquina local utilizando o Git ou sua ferramenta de controle de versão.

## 5. Abertura do Projeto no IntelliJ IDEA

- Abra o IntelliJ IDEA e importe o projeto clonado para a IDE.

## 6. Criação do Banco de Dados PostgreSQL

- No PostgreSQL, crie um novo banco de dados que será utilizado pelo projeto.

## 7. Configuração das Propriedades do Banco de Dados

- Abra o arquivo `Application.properties` do projeto no IntelliJ IDEA.
- Adicione as seguintes configurações para conectar ao banco de dados PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://${DATABASE_URL}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 8. Suba o servivor rodando a classe: ContactsapiApplication

## 9. Usando o postman instalado ou web pode usar os endpoints descritos acima!








  


