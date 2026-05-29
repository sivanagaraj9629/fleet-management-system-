# 🚚 Fleet Management System

A Spring Boot REST API for managing fleet vehicles, drivers, 
and delivery tasks with MySQL database integration.

---

## ✨ Features

- ✅ Vehicle Management (CRUD operations)
- ✅ Driver Management with License Tracking
- ✅ Delivery Task Assignment and Tracking
- ✅ Delivery Status Management
  - UNASSIGNED → DISPATCHED → IN_TRANSIT → DELIVERED
- ✅ Global Exception Handling
- ✅ Data Validation
- ✅ MySQL Database Integration
- ✅ RESTful API Architecture
- ✅ Service Layer Pattern
- ✅ Repository Pattern Implementation

---

## 🛠️ Technology Stack

| Category | Technology |
|----------|-----------|
| Backend Framework | Spring Boot 3.5.14 |
| Language | Java 17 |
| Database | MySQL 8.0 |
| ORM | Spring Data JPA / Hibernate 6.6 |
| Build Tool | Maven 3.9 |
| Validation | Hibernate Validator |
| Utilities | Lombok 1.18 |
| API Type | RESTful API |

---

## 🏗️ Architecture
┌─────────────────────────────────────┐
│ Client (Postman) │
└──────────────┬──────────────────────┘
│
┌──────────────▼──────────────────────┐
│ REST Controllers │
│ (Vehicle, Driver, Delivery) │
└──────────────┬──────────────────────┘
│
┌──────────────▼──────────────────────┐
│ Service Layer │
│ (Business Logic) │
└──────────────┬──────────────────────┘
│
┌──────────────▼──────────────────────┐
│ Repository Layer │
│ (Data Access) │
└──────────────┬──────────────────────┘
│
┌──────────────▼──────────────────────┐
│ MySQL Database │
│ (Persistent Data) │
└─────────────────────────────────────┘

text


---

## 📡 API Endpoints

### 🚗 Vehicle APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/vehicles` | Register new vehicle |
| GET | `/api/vehicles` | Get all vehicles |
| GET | `/api/vehicles/{id}` | Get vehicle by ID |
| GET | `/api/vehicles/available` | Get available vehicles |
| PATCH | `/api/vehicles/{id}/maintenance` | Update maintenance status |
| DELETE | `/api/vehicles/{id}` | Delete vehicle |

### 👨‍✈️ Driver APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/drivers` | Register new driver |
| GET | `/api/drivers` | Get all drivers |
| GET | `/api/drivers/{id}` | Get driver by ID |
| GET | `/api/drivers/available` | Get available drivers |
| PATCH | `/api/drivers/{id}/status` | Update driver status |
| DELETE | `/api/drivers/{id}` | Delete driver |

---

## 🗃️ Database Schema

### Tables Created
- **vehicles** - Fleet vehicle information
- **drivers** - Driver profiles and licenses
- **delivery_tasks** - Delivery assignments

### Entity Relationships
Vehicle (1) ──────── (Many) DeliveryTask
Driver (1) ──────── (Many) DeliveryTask

text


### Vehicle Table
```sql
id                  BIGINT (Primary Key)
license_plate       VARCHAR(20) UNIQUE
capacity_kg         DECIMAL(10,2)
vehicle_type        VARCHAR(50)
maintenance_status  ENUM(ACTIVE, MAINTENANCE, RETIRED)
last_service_date   DATE
created_at          TIMESTAMP
updated_at          TIMESTAMP
Driver Table
SQL

id                  BIGINT (Primary Key)
name                VARCHAR(100)
license_number      VARCHAR(50) UNIQUE
license_expiry      DATE
phone               VARCHAR(15)
email               VARCHAR(200)
status              ENUM(AVAILABLE, ON_DUTY, OFF_DUTY, ON_LEAVE)
max_shift_hours     INT
created_at          TIMESTAMP
updated_at          TIMESTAMP
Delivery Task Table
SQL

id                      BIGINT (Primary Key)
address                 VARCHAR(255)
latitude                DECIMAL(10,8)
longitude               DECIMAL(11,8)
delivery_window_start   TIME
delivery_window_end     TIME
package_weight          DECIMAL(10,2)
package_description     VARCHAR(255)
status                  ENUM(UNASSIGNED, DISPATCHED, IN_TRANSIT, DELIVERED, FAILED)
vehicle_id              BIGINT (Foreign Key)
driver_id               BIGINT (Foreign Key)
delivered_at            TIMESTAMP
created_at              TIMESTAMP
updated_at              TIMESTAMP
🚀 Getting Started
Prerequisites
text

- Java 17 or higher
- MySQL 8.0
- Maven 3.6+
Step 1: Clone Repository
Bash

git clone https://github.com/sivanagaraj9629/fleet-management-system-.git
cd fleet-management-system-
Step 2: Database Setup
SQL

CREATE DATABASE fleet_management;
USE fleet_management;
Step 3: Configuration
Update src/main/resources/application.properties:

properties

spring.datasource.url=jdbc:mysql://localhost:3306/fleet_management
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Step 4: Run Application
Bash

./mvnw spring-boot:run
Application starts on:

text

http://localhost:8080
📝 Sample API Requests
Register Vehicle
JSON

POST /api/vehicles
Content-Type: application/json

{
    "licensePlate": "TN01AB1234",
    "capacityKg": 5000,
    "vehicleType": "TRUCK",
    "lastServiceDate": "2024-01-15"
}
Response (201 Created):

JSON

{
    "id": 1,
    "licensePlate": "TN01AB1234",
    "capacityKg": 5000.00,
    "vehicleType": "TRUCK",
    "maintenanceStatus": "ACTIVE",
    "createdAt": "2024-05-27T15:00:00"
}
Register Driver
JSON

POST /api/drivers
Content-Type: application/json

{
    "name": "Rajesh Kumar",
    "licenseNumber": "TN12345ABC",
    "licenseExpiry": "2025-12-31",
    "phone": "9876543210",
    "email": "rajesh@example.com",
    "maxShiftHours": 10
}
Response (201 Created):

JSON

{
    "id": 1,
    "name": "Rajesh Kumar",
    "licenseNumber": "TN12345ABC",
    "status": "AVAILABLE",
    "maxShiftHours": 10,
    "createdAt": "2024-05-27T15:00:00"
}
Update Vehicle Maintenance Status
JSON

PATCH /api/vehicles/1/maintenance?status=MAINTENANCE
Response (200 OK):

JSON

{
    "id": 1,
    "licensePlate": "TN01AB1234",
    "maintenanceStatus": "MAINTENANCE",
    "updatedAt": "2024-05-27T16:00:00"
}
📁 Project Structure
text

src/main/java/com/fleet/management/
├── controller/
│   ├── VehicleController.java
│   └── DriverController.java
├── service/
│   ├── VehicleService.java
│   └── DriverService.java
├── repository/
│   ├── VehicleRepository.java
│   ├── DriverRepository.java
│   └── DeliveryTaskRepository.java
├── entity/
│   ├── Vehicle.java
│   ├── Driver.java
│   └── DeliveryTask.java
├── dto/
│   ├── VehicleDTO.java
│   └── DriverDTO.java
├── enums/
│   ├── MaintenanceStatus.java
│   ├── DriverStatus.java
│   └── DeliveryStatus.java
├── exception/
│   ├── GlobalExceptionHandler.java
│   ├── ResourceNotFoundException.java
│   ├── DuplicateResourceException.java
│   └── BusinessException.java
└── ManagementApplication.java
✅ Testing Status
Feature	Status
Vehicle Registration	✅ Tested
Vehicle Retrieval	✅ Tested
Vehicle Update	✅ Tested
Vehicle Delete	✅ Tested
Driver Registration	✅ Tested
Driver Retrieval	✅ Tested
Driver Update	✅ Tested
Driver Delete	✅ Tested
Exception Handling	✅ Tested
Data Validation	✅ Tested
Database Connection	✅ Tested
🔧 Error Handling
Exception	HTTP Status	Description
ResourceNotFoundException	404 Not Found	Resource not found
DuplicateResourceException	400 Bad Request	Duplicate entry
BusinessException	400 Bad Request	Business rule violation
General Exception	500 Internal Server Error	Unexpected error
Error Response Format:

JSON

{
    "status": 404,
    "message": "Vehicle not found with id: 1",
    "timestamp": "2024-05-27T15:00:00"
}
🚧 Future Enhancements
 JWT Authentication & Authorization
 Route Optimization Algorithm
 Docker Containerization
 Swagger API Documentation
 Unit & Integration Tests
 Real-time GPS Tracking
 Advanced Filtering & Pagination
📊 Project Stats
Total Entities: 3 (Vehicle, Driver, DeliveryTask)
Total API Endpoints: 12+
Database Tables: 3
Exception Types: 4
Technology Stack: 7 technologies
👨‍💻 Author
Sivanagaraj

GitHub: @sivanagaraj9629
📄 License
This project is open source and available under the MIT License.

Status: ✅ Complete & Tested
Version: 1.0.0
Last Updated: May 2026
