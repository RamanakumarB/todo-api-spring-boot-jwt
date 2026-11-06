# Todo REST API with JWT Authentication

A Spring Boot REST API with user registration, login and JWT-protected todo CRUD.

## Tech stack
Java 27, Spring Boot 4.1.1, Spring Security, JWT (jjwt), Spring Data JPA, PostgreSQL, Lombok, Maven

## Features
- Register and login with BCrypt-hashed passwords
- Stateless JWT authentication via a custom filter
- Todo CRUD with validation and pagination
- Swagger UI for API docs

## Endpoints
| Method | URL | Auth |
|---|---|---|
| POST | /auth/register | No |
| POST | /auth/login | No |
| GET | /api/v1/Todo | Yes |
| GET | /api/v1/Todo/{id} | Yes |
| GET | /api/v1/Todo/page | Yes |
| POST | /api/v1/Todo/create | Yes |
| PUT | /api/v1/Todo | Yes |
| DELETE | /api/v1/Todo/{id} | Yes |

Protected endpoints need the header `Authorization: Bearer <token>`.

## Run locally
1. Install JDK and PostgreSQL, then create a database named `tododb`.
2. Copy `.env.example` to `.env` and fill in your values.
3. Run `.\mvnw.cmd spring-boot:run`.
4. The API runs on http://localhost:8081.