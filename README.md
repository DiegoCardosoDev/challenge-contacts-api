# challenge-contacts-api

<div>
    <div style="display: inline_block"><br>
    <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" />
   <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
   <img src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white" />
   <img src="https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white" />
 </div>
  
# API para gestão de contatos


A API tem como objetivo gerenciar contatos, oferecendo funcionalidades para criar, buscar, atualizar e deletar contatos, bem como seus endereços associados.

## Funcionalidades

- **Criar Contato**: Permite criar um novo contato.
  
- **Buscar Todos os Contatos**: Retorna uma lista com todos os contatos cadastrados, incluindo seus respectivos endereços.
  
- **Buscar Contato por ID**: Retorna um contato específico com seus detalhes e lista de endereços.
  
- **Deletar Contato por ID**: Remove um contato específico e seus endereços associados. Ao deletar um contato, todos os seus endereços também são excluídos.

## Detalhes Adicionais

- Um contato pode ter mais de um endereço associado.
  
- Ao buscar ou deletar um contato, os endereços associados a esse contato são retornados ou excluídos, respectivamente.
  
- Para gerenciar múltiplos endereços, foi adicionada uma regra que permite definir um endereço como ativo.



## Tecnologias usadas:

- Java 17
- Spring Boot
- Mysql
- Maven para gerenciamento de dependências
- Swagger para documentação

## Dependências:

- Driver Mysql
- Spring data jpa
- Lombok
- Spring Web

## Execução Local do projeto

### Instalação:

- Java 17
- Mysql
- IDE Intellij
- Postman para chamadas Http

- crie  um banco no mysql
- abra o projeto na ide Intellijj
- aguarde o build do projeto



### Configuração:

1. Crie um banco no MySQL.

2. Abra o projeto na IDE Intellij.

3. Aguarde o build do projeto.

4. No arquivo `application.properties`, aplique as seguintes configurações:

```
spring.application.name=contactsapi
spring.datasource.url=jdbc:mysql://localhost:3306/seubancocriado?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=seu_user_name_do_mysql
spring.datasource.password=sua_senha_mysql
spring.jpa.hibernate.ddl-auto=none

spring.jpa.show-sql=true
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

## Links
- Swagger: http://localhost:8080/swagger-ui/index.html#/
- Clone do projeto: https://github.com/DiegoCardosoDev/challenge-contacts-api.git



  


