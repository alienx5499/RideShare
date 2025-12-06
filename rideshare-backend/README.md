<div align="center">

# **RideShare Backend**

### A modern ride-sharing backend API built with Spring Boot and MongoDB

[![Build Status](https://img.shields.io/badge/build-passing-success?style=flat-square)](https://github.com/alienX5499/rideshare)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen?style=flat-square)](https://spring.io/projects/spring-boot)
[![MongoDB](https://img.shields.io/badge/MongoDB-Latest-green?style=flat-square)](https://www.mongodb.com/)
[![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square)](https://www.oracle.com/java/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/alienX5499/rideshare/blob/main/LICENSE)
[![Contributions Welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat-square)](https://github.com/alienX5499/rideshare)

🚗 **Connect passengers with drivers. Simple, secure, scalable.**

</div>

---

## 🎯 **Overview**

RideShare Backend is a RESTful API service that powers a ride-sharing platform. It enables passengers to request rides and drivers to accept and complete them. Built with Spring Boot, it features JWT-based authentication, role-based access control, and comprehensive input validation.

### 🌟 **Key Features**

- 🔐 **JWT Authentication** - Secure token-based authentication with role-based access
- 👥 **Dual Role System** - Support for passengers (USER) and drivers (DRIVER)
- 🚕 **Ride Management** - Complete ride lifecycle from request to completion
- ✅ **Input Validation** - Jakarta Bean Validation for request validation
- 🛡️ **Global Exception Handling** - Centralized error handling with consistent error responses
- 📊 **MongoDB Integration** - NoSQL database for flexible data storage
- 🔒 **Security** - BCrypt password encoding and Spring Security integration

---

## 📚 **Table of Contents**

1. [Features](#-features)
2. [Tech Stack](#-tech-stack)
3. [Project Structure](#-project-structure)
4. [Prerequisites](#-prerequisites)
5. [Quick Start](#-quick-start)
6. [API Documentation](#-api-documentation)
7. [Architecture](#-architecture)
8. [Security](#-security)
9. [Testing](#-testing)
10. [Contributing](#-contributing)
11. [License](#-license)

---

## ✨ **Features**

### 🔐 **Authentication & Authorization**

- User registration with role assignment (USER or DRIVER)
- JWT-based login system
- Role-based endpoint protection
- Secure password hashing with BCrypt

### 🚕 **Ride Management**

- **Passengers** can:
  - Request new rides with pickup and drop locations
  - View their ride history
  - Complete accepted rides

- **Drivers** can:
  - View all pending ride requests
  - Accept available rides
  - Complete accepted rides

### 🛡️ **Data Validation**

- Request body validation using Jakarta Bean Validation
- Custom validation messages
- Automatic validation error responses

### 📝 **Error Handling**

- Global exception handler for consistent error responses
- Custom exception types (NotFoundException, BadRequestException)
- Detailed error messages with timestamps

---

## 🦾 **Tech Stack**

### **Backend Framework**
- **Spring Boot 3.2.0** - Application framework
- **Spring Security** - Authentication and authorization
- **Spring Data MongoDB** - Database integration
- **Jakarta Validation** - Input validation

### **Database**
- **MongoDB** - NoSQL document database

### **Security**
- **JWT (JSON Web Tokens)** - Token-based authentication
- **BCrypt** - Password hashing

### **Development Tools**
- **Maven** - Dependency management
- **Java 17** - Programming language

---

## 📂 **Project Structure**

```
rideshare-backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/example/rideshare/
│   │   │       ├── config/              # Security and JWT configuration
│   │   │       │   ├── SecurityConfig.java
│   │   │       │   └── JwtAuthenticationFilter.java
│   │   │       ├── controller/          # REST controllers
│   │   │       │   ├── AuthController.java
│   │   │       │   └── RideController.java
│   │   │       ├── dto/                 # Data Transfer Objects
│   │   │       │   ├── AuthResponse.java
│   │   │       │   ├── CreateRideRequest.java
│   │   │       │   ├── LoginRequest.java
│   │   │       │   ├── RegisterRequest.java
│   │   │       │   └── RideResponse.java
│   │   │       ├── exception/          # Custom exceptions
│   │   │       │   ├── BadRequestException.java
│   │   │       │   ├── GlobalExceptionHandler.java
│   │   │       │   └── NotFoundException.java
│   │   │       ├── model/              # Entity models
│   │   │       │   ├── Ride.java
│   │   │       │   └── User.java
│   │   │       ├── repository/         # Data access layer
│   │   │       │   ├── RideRepository.java
│   │   │       │   └── UserRepository.java
│   │   │       ├── service/           # Business logic
│   │   │       │   ├── AuthService.java
│   │   │       │   └── RideService.java
│   │   │       ├── util/              # Utilities
│   │   │       │   └── JwtUtil.java
│   │   │       └── RideshareApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

---

## 📋 **Prerequisites**

Before you begin, ensure you have the following installed:

- **Java 17** or higher
- **Maven 3.6+**
- **MongoDB** (local installation or connection string)
- **Git**

---

## 🚀 **Quick Start**

### **1. Clone the Repository**

```bash
git clone https://github.com/alienX5499/rideshare.git
cd rideshare/rideshare-backend
```

### **2. Configure MongoDB**

Update `src/main/resources/application.properties`:

```properties
# MongoDB Configuration
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=rideshare

# JWT Configuration
jwt.secret=your-secret-key-change-this-in-production-to-a-strong-random-string
jwt.expiration=86400000
```

### **3. Build and Run**

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The API will be available at `http://localhost:8081`

### **4. Verify Installation**

```bash
# Test the health endpoint (if available)
curl http://localhost:8081/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"username":"testuser","password":"1234","role":"ROLE_USER"}'
```

---

## 📖 **API Documentation**

### **Base URL**
```
http://localhost:8081
```

### **Authentication**

All protected endpoints require a JWT token in the Authorization header:
```
Authorization: Bearer <your-jwt-token>
```

---

### **Public Endpoints**

#### **1. Register User**

Register a new user (passenger or driver).

```http
POST /api/auth/register
Content-Type: application/json
```

**Request Body:**
```json
{
  "username": "john",
  "password": "1234",
  "role": "ROLE_USER"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "username": "john",
  "role": "ROLE_USER"
}
```

**Valid Roles:** `ROLE_USER`, `ROLE_DRIVER`

---

#### **2. Login**

Authenticate and receive a JWT token.

```http
POST /api/auth/login
Content-Type: application/json
```

**Request Body:**
```json
{
  "username": "john",
  "password": "1234"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "username": "john",
  "role": "ROLE_USER"
}
```

---

### **User Endpoints** (Requires `ROLE_USER`)

#### **3. Create Ride Request**

Request a new ride as a passenger.

```http
POST /api/v1/rides
Authorization: Bearer <token>
Content-Type: application/json
```

**Request Body:**
```json
{
  "pickupLocation": "Koramangala",
  "dropLocation": "Indiranagar"
}
```

**Response:**
```json
{
  "id": "65a1b2c3d4e5f6g7h8i9j0k1",
  "userId": "65a1b2c3d4e5f6g7h8i9j0k2",
  "driverId": null,
  "pickupLocation": "Koramangala",
  "dropLocation": "Indiranagar",
  "status": "REQUESTED",
  "createdAt": "2025-01-20T12:00:00Z"
}
```

---

#### **4. Get User Rides**

Get all rides for the authenticated user.

```http
GET /api/v1/user/rides
Authorization: Bearer <token>
```

**Response:**
```json
[
  {
    "id": "65a1b2c3d4e5f6g7h8i9j0k1",
    "userId": "65a1b2c3d4e5f6g7h8i9j0k2",
    "driverId": "65a1b2c3d4e5f6g7h8i9j0k3",
    "pickupLocation": "Koramangala",
    "dropLocation": "Indiranagar",
    "status": "ACCEPTED",
    "createdAt": "2025-01-20T12:00:00Z"
  }
]
```

---

### **Driver Endpoints** (Requires `ROLE_DRIVER`)

#### **5. Get Pending Ride Requests**

Get all rides with status `REQUESTED`.

```http
GET /api/v1/driver/rides/requests
Authorization: Bearer <token>
```

**Response:**
```json
[
  {
    "id": "65a1b2c3d4e5f6g7h8i9j0k1",
    "userId": "65a1b2c3d4e5f6g7h8i9j0k2",
    "driverId": null,
    "pickupLocation": "Koramangala",
    "dropLocation": "Indiranagar",
    "status": "REQUESTED",
    "createdAt": "2025-01-20T12:00:00Z"
  }
]
```

---

#### **6. Accept Ride**

Accept a pending ride request.

```http
POST /api/v1/driver/rides/{rideId}/accept
Authorization: Bearer <token>
```

**Response:**
```json
{
  "id": "65a1b2c3d4e5f6g7h8i9j0k1",
  "userId": "65a1b2c3d4e5f6g7h8i9j0k2",
  "driverId": "65a1b2c3d4e5f6g7h8i9j0k3",
  "pickupLocation": "Koramangala",
  "dropLocation": "Indiranagar",
  "status": "ACCEPTED",
  "createdAt": "2025-01-20T12:00:00Z"
}
```

---

### **Shared Endpoints**

#### **7. Complete Ride**

Mark a ride as completed (available to both USER and DRIVER).

```http
POST /api/v1/rides/{rideId}/complete
Authorization: Bearer <token>
```

**Response:**
```json
{
  "id": "65a1b2c3d4e5f6g7h8i9j0k1",
  "userId": "65a1b2c3d4e5f6g7h8i9j0k2",
  "driverId": "65a1b2c3d4e5f6g7h8i9j0k3",
  "pickupLocation": "Koramangala",
  "dropLocation": "Indiranagar",
  "status": "COMPLETED",
  "createdAt": "2025-01-20T12:00:00Z"
}
```

---

### **Ride Status Flow**

```
REQUESTED → ACCEPTED → COMPLETED
```

- **REQUESTED**: Passenger has created a ride request
- **ACCEPTED**: Driver has accepted the ride
- **COMPLETED**: Ride has been completed

---

## 🏗️ **Architecture**

### **Layered Architecture**

```
┌─────────────────────────────────────┐
│         Controller Layer            │  ← REST API Endpoints
├─────────────────────────────────────┤
│         Service Layer               │  ← Business Logic
├─────────────────────────────────────┤
│         Repository Layer            │  ← Data Access
├─────────────────────────────────────┤
│         MongoDB Database            │  ← Data Storage
└─────────────────────────────────────┘
```

### **Request Flow**

1. **Client** sends HTTP request
2. **JwtAuthenticationFilter** validates JWT token
3. **Controller** receives request and validates input
4. **Service** processes business logic
5. **Repository** interacts with MongoDB
6. **Response** returned to client

### **Entity Relationships**

```
USER (ROLE_USER)       DRIVER (ROLE_DRIVER)
        │                         │
        │ requests                │ accepts
        ▼                         ▼
    ┌────────────────────────────────┐
    │              RIDE              │
    ├────────────────────────────────┤
    │ userId     → USER.id           │
    │ driverId   → DRIVER.id         │
    │ status     → REQUESTED/ACCEPT  │
    └────────────────────────────────┘
```

---

## 🔐 **Security**

### **Authentication Flow**

1. User registers/logs in
2. Server generates JWT token with username and role
3. Client stores token
4. Client includes token in `Authorization: Bearer <token>` header
5. Server validates token on each request

### **Password Security**

- Passwords are hashed using BCrypt before storage
- Plain text passwords are never stored in the database

### **Role-Based Access Control**

- **ROLE_USER**: Can create rides and view their own rides
- **ROLE_DRIVER**: Can view pending requests and accept rides
- Both roles can complete rides

---

## 🧪 **Testing**

### **Using cURL**

#### **1. Register a User**
```bash
curl -X POST http://localhost:8081/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"username":"john","password":"1234","role":"ROLE_USER"}'
```

#### **2. Register a Driver**
```bash
curl -X POST http://localhost:8081/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"username":"driver1","password":"abcd","role":"ROLE_DRIVER"}'
```

#### **3. Login**
```bash
curl -X POST http://localhost:8081/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"john","password":"1234"}'
```

#### **4. Create a Ride** (Replace `<token>` with actual token)
```bash
curl -X POST http://localhost:8081/api/v1/rides \
  -H "Authorization: Bearer <token>" \
  -H "Content-Type: application/json" \
  -d '{"pickupLocation":"Koramangala","dropLocation":"Indiranagar"}'
```

#### **5. Get Pending Rides** (Driver only)
```bash
curl -X GET http://localhost:8081/api/v1/driver/rides/requests \
  -H "Authorization: Bearer <driver-token>"
```

#### **6. Accept a Ride** (Driver only)
```bash
curl -X POST http://localhost:8081/api/v1/driver/rides/{rideId}/accept \
  -H "Authorization: Bearer <driver-token>"
```

#### **7. Complete a Ride**
```bash
curl -X POST http://localhost:8081/api/v1/rides/{rideId}/complete \
  -H "Authorization: Bearer <token>"
```

---

## 📝 **Error Responses**

All errors follow a consistent format:

```json
{
  "error": "ERROR_TYPE",
  "message": "Error message description",
  "timestamp": "2025-01-20T12:00:00Z"
}
```

### **Error Types**

- `NOT_FOUND` - Resource not found (404)
- `BAD_REQUEST` - Invalid request data (400)
- `VALIDATION_ERROR` - Input validation failed (400)
- `AUTHENTICATION_ERROR` - Authentication failed (401)
- `INTERNAL_SERVER_ERROR` - Server error (500)

### **Example Error Response**

```json
{
  "error": "VALIDATION_ERROR",
  "message": {
    "pickupLocation": "Pickup is required"
  },
  "timestamp": "2025-01-20T12:00:00Z"
}
```

---

## 🤝 **Contributing**

We welcome contributions! Please follow these steps:

1. **Fork the repository**
   ```bash
   git clone https://github.com/alienX5499/rideshare.git
   ```

2. **Create a feature branch**
   ```bash
   git checkout -b feature/amazing-feature
   ```

3. **Make your changes** and commit
   ```bash
   git commit -m "Add amazing feature"
   ```

4. **Push to your branch**
   ```bash
   git push origin feature/amazing-feature
   ```

5. **Open a Pull Request**

### **Contribution Guidelines**

- Follow existing code style and conventions
- Add tests for new features
- Update documentation as needed
- Ensure all tests pass before submitting

---

## 📜 **License**

This project is licensed under the **MIT License**. See [LICENSE](https://github.com/alienX5499/rideshare/blob/main/LICENSE) for details.

---

## 📬 **Support & Feedback**

- **Issues**: [GitHub Issues](https://github.com/alienX5499/rideshare/issues)
- **Repository**: [GitHub Repository](https://github.com/alienX5499/rideshare)

---

<div align="center">

**Built with ❤️ using Spring Boot**

[⭐ Star this repo](https://github.com/alienX5499/rideshare) if you find it helpful!

</div>
