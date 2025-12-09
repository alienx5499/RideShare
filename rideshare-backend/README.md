<div align="center">

# **RideShare Backend**

### A modern ride-sharing backend API built with Spring Boot and MongoDB

[![Build Passing](https://img.shields.io/badge/build-passing-success?style=flat-square)](https://github.com/alienX5499/rideshare/actions)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen?style=flat-square)](https://spring.io/projects/spring-boot)
[![MongoDB](https://img.shields.io/badge/MongoDB-Latest-green?style=flat-square)](https://www.mongodb.com/)
[![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square)](https://www.oracle.com/java/)
[![License: MIT](https://custom-icon-badges.herokuapp.com/github/license/alienX5499/rideshare?logo=law&logoColor=white)](https://github.com/alienX5499/rideshare/blob/main/LICENSE)
[![Contributions Welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat-square)](https://github.com/alienX5499/rideshare/blob/main/CONTRIBUTING.md)
[![Platform](https://img.shields.io/badge/platform-Spring%20Boot-brightgreen?style=flat-square)](https://spring.io/projects/spring-boot)
[![Views](https://visitor-badge.laobi.icu/badge?page_id=alienx5499.rideshare)](https://visitor-badge.laobi.icu/badge?page_id=alienx5499.rideshare)
[![⭐ GitHub stars](https://img.shields.io/github/stars/alienX5499/rideshare?style=social)](https://github.com/alienX5499/rideshare/stargazers)
[![🍴 GitHub forks](https://img.shields.io/github/forks/alienX5499/rideshare?style=social)](https://github.com/alienX5499/rideshare/network)
[![Commits](https://badgen.net/github/commits/alienX5499/rideshare)](https://github.com/alienX5499/rideshare/commits/main)
[![🐛 GitHub issues](https://img.shields.io/github/issues/alienX5499/rideshare)](https://github.com/alienX5499/rideshare/issues)
[![📂 GitHub pull requests](https://img.shields.io/github/issues-pr/alienX5499/rideshare)](https://github.com/alienX5499/rideshare/pulls)
[![💾 GitHub code size](https://img.shields.io/github/languages/code-size/alienX5499/rideshare)](https://github.com/alienX5499/rideshare)

🚗 **Connect passengers with drivers. Simple, secure, scalable.**

</div>

---

## 🎯 **What is RideShare Backend?**

RideShare Backend is a RESTful API service that powers a ride-sharing platform. It enables passengers to request rides and drivers to accept and complete them. Built with Spring Boot, it features JWT-based authentication, role-based access control, and comprehensive input validation.

> **📌 Key Focus:** This backend provides a complete ride-sharing API with secure authentication, role-based access control, and a full ride lifecycle management system. The goal is to demonstrate a production-ready Spring Boot application with MongoDB integration, JWT security, and comprehensive error handling.

### 🌟 **Key Features**

- ⚡ **JWT Authentication** - Secure token-based authentication with role-based access
- 👥 **Dual Role System** - Support for passengers (USER) and drivers (DRIVER)
- 🚕 **Complete Ride Management** - Full ride lifecycle from request to completion
- ✅ **Input Validation** - Jakarta Bean Validation for all requests
- 🛡️ **Global Exception Handling** - Centralized error handling with consistent responses
- 📊 **MongoDB Integration** - Flexible NoSQL database for scalable data storage
- 🔒 **Security** - BCrypt password encoding and Spring Security integration

> Connect passengers with drivers. Simple, secure, scalable.

<div align="center">

### Build with us

Need a ride-sharing backend? You're exactly who we built this for.

<a href="https://github.com/alienX5499/rideshare">
  <img src="https://img.shields.io/badge/⭐%20Star%20this%20repo-Be%20part%20of%20our%20community!-yellow?style=for-the-badge&logo=github" alt="Star this repo" />
</a>

<a href="https://twitter.com/intent/tweet?text=🔥%20WOW!%20RideShare%20Backend%20is%20a%20powerful%20ride-sharing%20API%20built%20with%20Spring%20Boot!%20JWT%20auth,%20MongoDB,%20role-based%20access!%20🚀✨%0AIf%20you%20need%20a%20ride-sharing%20backend%20-%20you%20NEED%20this!%20%F0%9F%9A%80%0Ahttps://github.com/alienX5499/rideshare%0A@alienX5499">
<img src="https://img.shields.io/badge/Share-Help%20a%20fellow%20developer!-1DA1F2?style=for-the-badge&logo=twitter" alt="Tweet about RideShare" />
</a>

Every star helps us build a more robust and scalable ride-sharing platform.

</div>

---

## 📚 **Table of Contents**

1. [✨ Features](#-features)
2. [🦾 Tech Stack](#-tech-stack)
3. [📂 Project Structure](#-project-structure)
4. [🚀 Quick Start](#-quick-start)
5. [👨‍🔧 Detailed Setup](#-detailed-setup)
6. [📖 API Documentation](#-api-documentation)
7. [🏗️ Architecture](#️-architecture)
8. [🔐 Security](#-security)
9. [🧪 Testing](#-testing)
10. [🤝 Contributing](#-contributing)
11. [📜 License](#-license)
12. [📬 Feedback & Suggestions](#-feedback--suggestions)

---

## ✨ **Features**

### 🔐 **Authentication & Authorization**

- **User Registration**: Register with role assignment (USER or DRIVER)
- **JWT-Based Login**: Secure token-based authentication system
- **Role-Based Endpoint Protection**: Different permissions for USER and DRIVER roles
- **Password Security**: BCrypt hashing for secure password storage
- **Token Validation**: Automatic JWT token validation on protected endpoints

### 🚕 **Ride Management**

- **Passengers** can:
  - Request new rides with pickup and drop locations
  - View their complete ride history
  - Complete accepted rides
  
- **Drivers** can:
  - View all pending ride requests
  - Accept available rides
  - Complete accepted rides

### 🛡️ **Data Validation**

- **Jakarta Bean Validation**: Request body validation on all DTOs
- **Custom Validation Messages**: User-friendly error messages
- **Automatic Validation Error Responses**: Consistent error format
- **Input Sanitization**: Protection against invalid data

### 📝 **Error Handling**

- **Global Exception Handler**: Centralized error handling for consistent responses
- **Custom Exception Types**: NotFoundException, BadRequestException for specific scenarios
- **Detailed Error Messages**: Comprehensive error information with timestamps
- **HTTP Status Codes**: Proper status code mapping for different error types

---

## 🦾 **Tech Stack**

### ⛓️ **Backend Framework**

- **Spring Boot 3.2.0** - Application framework
- **Spring Security** - Authentication and authorization
- **Spring Data MongoDB** - Database integration
- **Jakarta Validation** - Input validation

### 🗄️ **Database**

- **MongoDB** - NoSQL document database for flexible data storage

### 🔒 **Security**

- **JWT (JSON Web Tokens)** - Token-based authentication
- **BCrypt** - Password hashing algorithm
- **Spring Security** - Security framework integration

### 🛠️ **Development Tools**

- **Maven** - Dependency management and build tool
- **Java 17** - Programming language
- **Git** - Version control

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
│   │   │       │   ├── RideController.java
│   │   │       │   └── AnalyticsController.java
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
│   │   │       │   ├── RideService.java
│   │   │       │   └── AnalyticsService.java
│   │   │       ├── util/              # Utilities
│   │   │       │   └── JwtUtil.java
│   │   │       └── RideshareApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/                           # Test files
└── pom.xml                              # Maven dependencies
```

### 📁 **Key Directories**:

- **`config/`**: Security configuration and JWT authentication filter
- **`controller/`**: REST API endpoints for authentication, ride management, and analytics
- **`dto/`**: Data Transfer Objects with validation annotations
- **`exception/`**: Custom exceptions and global exception handler
- **`model/`**: Entity models with MongoDB annotations
- **`repository/`**: Data access layer with custom queries
- **`service/`**: Business logic layer (auth, ride lifecycle, analytics)
- **`util/`**: Utility classes for JWT operations

---

## 🚀 **Quick Start**

### **Prerequisites**

- **Java 17** or higher
- **Maven 3.6+**
- **MongoDB** (local installation or connection string)
- **Git**

### **1. Clone & Install**

```bash
# Clone the repository
git clone https://github.com/alienX5499/rideshare.git
cd rideshare/rideshare-backend

# Build the project
mvn clean install
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

### **3. Run the Application**

```bash
# Run the application
mvn spring-boot:run

# The API will be available at http://localhost:8081
```

### **4. Verify Installation**

```bash
# Test the registration endpoint
curl -X POST http://localhost:8081/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"username":"testuser","password":"1234","role":"ROLE_USER"}'
```

---

## 👨‍🔧 **Detailed Setup**

### **Prerequisites Installation**

1. **Install Java 17+**:
   - Download from [Oracle](https://www.oracle.com/java/technologies/downloads/) or use OpenJDK
   - Verify installation: `java -version`

2. **Install Maven**:
   ```bash
   # macOS
   brew install maven
   
   # Linux
   sudo apt-get install maven
   
   # Verify installation
   mvn -version
   ```

3. **Install MongoDB**:
   ```bash
   # macOS
   brew tap mongodb/brew
   brew install mongodb-community
   
   # Start MongoDB
   brew services start mongodb-community
   
   # Linux
   sudo apt-get install mongodb
   sudo systemctl start mongodb
   ```

### **Application Setup**

```bash
cd rideshare-backend

# Install dependencies and build
mvn clean install

# Run the application
mvn spring-boot:run
```

### **Configuration**

Update `src/main/resources/application.properties` with your MongoDB connection details and JWT secret key.

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

The application follows a clean layered architecture:

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

### 🔎 **Advanced Ride Search & Filters**

These endpoints provide richer querying over rides data (search, filters, sorting, pagination):

- `GET /api/v1/rides/search?text=kor` – Search by pickup or drop location (case-insensitive)
- `GET /api/v1/rides/filter-distance?min=2&max=10` – Filter rides by `distanceKm` range
- `GET /api/v1/rides/filter-date-range?start=2025-01-01&end=2025-01-31` – Filter by `createdDate` range
- `GET /api/v1/rides/sort?order=asc|desc` – Sort rides by `fareAmount`
- `GET /api/v1/rides/user/{userId}` – All rides for a specific user
- `GET /api/v1/rides/user/{userId}/status/{status}` – Rides for a user filtered by status
- `GET /api/v1/driver/{driverId}/active-rides` – Active rides (status `ACCEPTED`) for a driver
- `GET /api/v1/rides/filter-status?status=COMPLETED&search=kor` – Combine status filter with keyword search
- `GET /api/v1/rides/advanced-search?search=kor&status=REQUESTED&sort=fareAmount&order=asc&page=0&size=10` – Advanced search with multiple criteria and pagination

---

### 📊 **Analytics Endpoints**

Aggregation-based analytics over rides data (MongoDB aggregations):

- `GET /api/analytics/driver/{driver}/earnings` – Total earnings for a driver
- `GET /api/v1/analytics/rides-per-day` – Rides count grouped by `createdDate`
- `GET /api/v1/analytics/driver/{driverId}/summary` – Driver summary (rides, completed/cancelled count, avg distance, total fare)
- `GET /api/v1/analytics/user/{userId}/spending` – Total amount spent and completed rides for a user
- `GET /api/v1/analytics/status-summary` – Ride counts grouped by `status`

---

## 🔐 **Security**

### **Security Features**

- **JWT Authentication**: All protected endpoints require a valid JWT token
- **Role-Based Access Control**: Different permissions for USER and DRIVER roles
- **Password Security**: BCrypt hashing for secure password storage
- **Input Validation**: Jakarta Bean Validation on all DTOs
- **Global Exception Handling**: Consistent error responses
- **Token Expiration**: Configurable JWT token expiration

### **Authentication Flow**

1. User registers/logs in
2. Server generates JWT token with username and role
3. Client stores token
4. Client includes token in `Authorization: Bearer <token>` header
5. Server validates token on each request

### **Password Security**

- Passwords are hashed using BCrypt before storage
- Plain text passwords are never stored in the database
- BCrypt automatically handles salt generation

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

We ❤️ open source! Your contributions make this project better.

### **How to Contribute**

1. **Fork the Repository**
   ```bash
   git clone https://github.com/your-username/rideshare.git
   ```

2. **Create Feature Branch**
   ```bash
   git checkout -b feature/amazing-feature
   ```

3. **Commit Changes**
   ```bash
   git commit -m "Add amazing feature"
   ```

4. **Push to Branch**
   ```bash
   git push origin feature/amazing-feature
   ```

5. **Open Pull Request**

### **Contribution Guidelines**

- Follow the existing code style
- Add tests for new features
- Update documentation
- Keep commits clean and meaningful
- Test on local environment before submitting

---

## 📜 **License**

This project is licensed under the **MIT License**. See [LICENSE](https://github.com/alienX5499/rideshare/blob/main/LICENSE) for full terms.

Unless otherwise noted in a file header, all source code in this repository is provided under the MIT License. Individual files or components that include their own license headers remain under those specified terms.

---

<div align="center">

### 📬 **Feedback & Suggestions**

_We value your input! Share your thoughts through [GitHub Issues](https://github.com/alienX5499/rideshare/issues)._

💡 _Let's work together to build a more robust and scalable ride-sharing platform!_

**🚀 LFG!**

</div>

---
