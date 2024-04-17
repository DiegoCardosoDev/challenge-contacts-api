# challenge-contacts-api
# API para gestão de contatos

## Tecnologias usadas:

- Java 17
- Spring Boot
- Mysql
- Maven para gerenciamento de dependências

## Dependências:

- Driver Mysql
- Spring data jpa
- Lombok
- Spring Web

## Execução do projeto

### Instalação:

- Java 17
- Mysql
- IDE Intellij
- Postman para chamadas Http

### Clone do projeto:

- crie  um banco no mysql
- abra o projeto na ide Intellijj
- aguarde o build do projeto



### Configuração:

1. Crie um banco no MySQL.

2. Abra o projeto na IDE Intellij.

3. Aguarde o build do projeto.

4. No arquivo `application.properties`, aplique as seguintes configurações:

```properties
spring.application.name=contactsapi
spring.datasource.url=jdbc:mysql://localhost:3306/seubancocriado?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=seu_user_name_do_mysql
spring.datasource.password=sua_senha_mysql
spring.jpa.hibernate.ddl-auto=none

spring.jpa.show-sql=true
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

  


