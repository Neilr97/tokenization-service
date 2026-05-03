# Tokenization Service

A Spring Boot REST API that tokenizes sensitive account numbers into secure random tokens and allows reverse lookup (detokenization).

The system uses an in-memory H2 database to store mappings between original values and generated tokens.

---

## Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database (in-memory)
- Maven (wrapper included)
- JUnit & Mockito

---

## Features

- Tokenize sensitive account numbers into unique tokens
- Detokenize tokens back to original values
- REST API design
- In-memory storage for fast lookup
- Layered architecture (Controller → Service → Repository)

---

## Running the Application

### Start the application (COPY-PASTE SAFE)

```bash
./mvnw spring-boot:run
```

Windows alternative:

```bash
mvnw.cmd spring-boot:run
```

Application runs at:

```
http://localhost:3000
```

---

## API Endpoints

### Tokenize

```bash
curl -X POST "http://localhost:3000/tokenize" -H "Content-Type: application/json" -d "[\"4111-1111-1111-1111\",\"4444-3333-2222-1111\"]"
```

Response:
```json
[
  "a3588f42eb8b41149fc4d75f2b79cb8c",
  "8b55bbf2da954338916b6bfc37eecb99"
]
```

---

### Detokenize

```bash
curl -X POST "http://localhost:3000/detokenize" -H "Content-Type: application/json" -d "[\"a3588f42eb8b41149fc4d75f2b79cb8c\"]"
```

Response:
```json
[
  "4111-1111-1111-1111"
]
```

---

## H2 Database Console

```
http://localhost:3000/h2-console
```

Login:
- JDBC URL: jdbc:h2:mem:tokendb
- Username: sa
- Password: (blank)

---

## Running Tests

```bash
./mvnw test
```

---

## Design Overview

- REST API built with Spring Boot
- Controller → Service → Repository architecture
- UUID-based token generation
- In-memory H2 database for development/testing

---

## Future Improvements

- Replace UUID with cryptographically secure token generation (SecureRandom / HMAC)
- Encrypt sensitive data at rest (AES-256)
- Migrate from H2 to PostgreSQL
- Add authentication and authorization (JWT / OAuth2)
- Implement rate limiting for API protection
- Add observability (Spring Actuator: metrics, health checks)
- Containerize application using Docker

---

## Author

Neil Ramanandi
