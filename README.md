# Todo App: Spring Boot REST API with JWT Authentication

A full-stack Todo app. The backend is a Spring Boot REST API with user registration, login and JWT-protected todo CRUD. The frontend is plain HTML, CSS and JavaScript.

## Project structure
```
├── backend/     Spring Boot API (Java, Maven, PostgreSQL)
├── frontend/    HTML, CSS and JavaScript pages (login, register, todos)
├── .gitignore
└── README.md
```

## Tech stack
**Backend:** Java 27, Spring Boot 4.1.1, Spring Security, JWT (jjwt), Spring Data JPA, PostgreSQL, Lombok, Maven
**Frontend:** HTML, CSS, JavaScript (Fetch API)

## Features
- Register and login with BCrypt-hashed passwords
- Stateless JWT authentication via a custom filter
- Todo CRUD with validation and pagination
- Swagger UI for API docs
- Frontend that stores the JWT in `localStorage` and sends it with every todo request

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

## Run the backend
1. Install JDK and PostgreSQL, then create a database named `tododb`.
2. Go to the backend folder:
   ```
   cd backend
   ```
3. Copy `.env.example` to `.env` and fill in your values (`DB_USERNAME`, `DB_PASSWORD`, `JWT_SECRET`). The secret must be at least 32 characters.
4. Set the variables and start the app.

   **IntelliJ:** Run → Edit Configurations → select your `.env` file in the Environment variables field, then run `HelloWorldApplication`.

   **PowerShell:**
   ```
   $env:DB_PASSWORD="your_password"
   $env:JWT_SECRET="your_long_random_secret"
   .\mvnw.cmd spring-boot:run
   ```
5. The API runs on http://localhost:8081.
6. Swagger UI: http://localhost:8081/swagger-ui.html

## Run the frontend
1. Start the backend first.
2. In a new terminal:
   ```
   cd frontend
   python -m http.server 5500
   ```
3. Open http://localhost:5500/login.html
4. Register, log in, then add, tick and delete todos.

Serving the files over HTTP avoids the browser errors that appear when opening them directly with `file://`.

## Security notes
- Passwords are hashed with BCrypt and never stored in plain text.
- The JWT secret and database password come from environment variables, not from the code.
- `.env` is listed in `.gitignore`. Only `.env.example`, with fake values, is committed.