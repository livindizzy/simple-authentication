# Simple Authentication Service

Simple Authentication Service is a REST API built with Spring Boot that provides user authentication using JWT (JSON Web Token).  
This service is designed to handle authentication and generate tokens that can be used by other services.

## Tech Stack

- Java 21
- Spring Boot 3.3.5
- Spring Web
- Spring Data JPA
- PostgreSQL
- JWT (io.jsonwebtoken)
- Lombok
- ModelMapper
- OpenFeign
- Swagger / OpenAPI
- Maven

## Prerequisites

Before running this service, make sure the following are installed:

- Java 21
- Maven
- PostgreSQL

The service will run at:

```
http://localhost:8092
```

## API Documentation

After the application is running, you can access the Swagger documentation at:

```
http://localhost:8080/swagger-ui/index.html
```

## Authentication Usage

1. Send a login request to the authentication API.
2. The service validates the credentials.
3. If valid, a JWT token will be generated.
4. Use the token in other services with the header:
