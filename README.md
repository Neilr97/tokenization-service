# Tokenization Service

A Spring Boot REST API that tokenizes sensitive account numbers into secure random tokens and allows reverse lookup (detokenization).

The system uses an in-memory H2 database to store the mapping between original values and generated tokens.

---

## Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database (in-memory)
- Maven (with wrapper)
- JUnit & Mockito

---

## Features

- Tokenize sensitive account numbers into unique tokens
- Detokenize tokens back to original values
- RESTful API design
- In-memory database for fast lookup
- Layered architecture (Controller → Service → Repository)
- Unit-tested service layer

---

## Project Structure

src/
 ├── main/java/com/example/tokenization
 │    ├── controller
 │    ├── service
 │    ├── repository
 │    └── model
 │
 └── test/java/com/example/tokenization
      └── TokenServiceTest.java

---

## Running the Application

### Prerequisites
- Java 17+
- No Maven installation required (uses Maven wrapper)

### Start the application

./mvnw spring-boot:run

The service will start at:

http://localhost:3000

Note: If no custom port is configured, Spring Boot may default to 8080.

---

## API Endpoints

### 1. Tokenize

POST /tokenize

Request:
[
  "4111-1111-1111-1111",
  "4444-3333-2222-1111"
]

Response:
[
  "a3588f42eb8b41149fc4d75f2b79cb8c",
  "8b55bbf2da954338916b6bfc37eecb99"
]

---

### 2. Detokenize

POST /detokenize

Request:
[
  "a3588f42eb8b41149fc4d75f2b79cb8c"
]

Response:
[
  "4111-1111-1111-1111"
]

---

## API Testing (cURL)

### Tokenize

curl -X POST http://localhost:3000/tokenize \
  -H "Content-Type: application/json" \
  -d '["4111-1111-1111-1111","4444-3333-2222-1111"]'

---

### Detokenize

curl -X POST http://localhost:3000/detokenize \
  -H "Content-Type: application/json" \
  -d '["a3588f42eb8b41149fc4d75f2b79cb8c"]'

---

## H2 Database Console (Optional Debugging)

http://localhost:3000/h2-console

Login Details:
- JDBC URL: jdbc:h2:mem:tokendb
- Username: sa
- Password: (leave blank)

---

## Running Tests

./mvnw test

---

## Design Overview

- REST API built with Spring Boot
- Stateless request/response design
- Controller → Service → Repository layered architecture
- Token generation uses UUID for uniqueness
- In-memory H2 database for fast lookup and development use

---

## Future Improvements

- Use cryptographically secure token generation
- Add input validation and error handling
- Add authentication and authorization (JWT / OAuth2)
- Replace H2 with PostgreSQL for persistence
- Add Swagger/OpenAPI documentation

---

## Author

Neil Ramanandi
