# Tokenization Service

## Overview

This project is a Spring Boot REST API that tokenizes sensitive account numbers into random tokens and allows reverse lookup (detokenization).

The system uses an in-memory H2 database to store the mapping between tokens and original account numbers.

---

## Tech Stack

* Java 17+
* Spring Boot
* Spring Data JPA
* H2 Database (in-memory)
* Maven
* JUnit & Mockito (unit testing)

---

## Features

* Tokenize account numbers into random strings
* Detokenize tokens back to original account numbers
* In-memory database for fast lookup
* RESTful API design
* Unit tests for service layer

---

## Project Structure

```
src/
 ├── main/java/com/example/tokenization
 │    ├── controller
 │    ├── service
 │    ├── repository
 │    └── model
 │
 └── test/java/com/example/tokenization
      └── TokenServiceTest.java
```

---

## API Endpoints

### 1. Tokenize

**POST** `/tokenize`

#### Request

```json
[
  "4111-1111-1111-1111",
  "4444-3333-2222-1111",
  "4444-1111-2222-3333"
]
```

#### Response

```json
[
  "generated-token-1",
  "generated-token-2",
  "generated-token-3"
]
```

---

### 2. Detokenize

**POST** `/detokenize`

#### Request

```json
[
  "generated-token-1"
]
```

#### Response

```json
[
  "4111-1111-1111-1111"
]
```

---

## Running the Application

### 1. Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/tokenization-service.git
cd tokenization-service
```

### 2. Run the application

```bash
mvn spring-boot:run
```

Application runs at:

```
http://localhost:3000
```

---

## API Testing (cURL)

Ensure the application is running before executing the commands.

### Tokenize

```bash
curl -X POST http://localhost:3000/tokenize \
-H "Content-Type: application/json" \
-d "[\"4111-1111-1111-1111\",\"4444-3333-2222-1111\",\"4444-1111-2222-3333\"]"
```

### Example Response

```json
[
  "a3588f42eb8b41149fc4d75f2b79cb8c",
  "8b55bbf2da954338916b6bfc37eecb99",
  "62c4e057ecc8466694e6e6507e34c743"
]
```

---

### Detokenize

```bash
curl -X POST http://localhost:3000/detokenize \
-H "Content-Type: application/json" \
-d "[\"<TOKEN>\"]"
```

### Example

```bash
curl -X POST http://localhost:3000/detokenize \
-H "Content-Type: application/json" \
-d "[\"a3588f42eb8b41149fc4d75f2b79cb8c\"]"
```

### Example Response

```json
[
  "4111-1111-1111-1111"
]
```

---

## PowerShell (Windows Users)

### Tokenize

```powershell
Invoke-RestMethod -Uri "http://localhost:3000/tokenize" `
-Method POST `
-Headers @{ "Content-Type" = "application/json" } `
-Body '["4111-1111-1111-1111","4444-3333-2222-1111"]'
```

### Detokenize

```powershell
Invoke-RestMethod -Uri "http://localhost:3000/detokenize" `
-Method POST `
-Headers @{ "Content-Type" = "application/json" } `
-Body '["<TOKEN>"]'
```

---

## H2 Database Console

Access:

```
http://localhost:3000/h2-console
```

### Login Details

* JDBC URL: `jdbc:h2:mem:tokendb`
* Username: `sa`
* Password: (leave blank)

### Sample Query

```sql
SELECT * FROM TOKEN_ENTITY;
```

---

## Running Tests

```bash
mvn test
```

---

## Design Notes

* Tokens are generated using UUID to ensure randomness and uniqueness
* Token-to-account mapping is stored in H2 (in-memory database)
* Service layer is unit tested using Mockito
* Layered architecture: Controller → Service → Repository → Database

---

## Future Improvements

* Use cryptographically secure token generation
* Add validation and error handling
* Encrypt sensitive data
* Use persistent database (e.g. PostgreSQL)
* Add authentication and security

---

## Author
Neil Ramanandi