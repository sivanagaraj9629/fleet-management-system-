# 🚚 Fleet Management System

A Spring Boot REST API for managing fleet vehicles, drivers, and delivery tasks with MySQL database integration.

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- MySQL 8.0
- Maven 3.6+

### Step 1: Clone Repository
```bash
git clone https://github.com/sivanagaraj9629/fleet-management-system-.git
cd fleet-management-system-
```

### Step 2: Database Setup
```sql
CREATE DATABASE fleet_management;
USE fleet_management;
```

### Step 3: Configuration
Update `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/fleet_management
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Step 4: Run Application
```bash
./mvnw spring-boot:run
```

Application starts on: `http://localhost:8080`

---

## 📝 Sample API Requests

### Register Vehicle
```http
POST /api/vehicles
Content-Type: application/json

{
    "licensePlate": "TN01AB1234",
    "capacityKg": 5000,
    "vehicleType": "TRUCK",
    "lastServiceDate": "2024-01-15"
}
```

**Response (201 Created):**
```json
{
    "id": 1,
    "licensePlate": "TN01AB1234",
    "capacityKg": 5000.00,
    "vehicleType": "TRUCK",
    "maintenanceStatus": "ACTIVE",
    "createdAt": "2024-05-27T15:00:00"
}
```

### Register Driver
```http
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
```

**Response (201 Created):**
```json
{
    "id": 1,
    "name": "Rajesh Kumar",
    "licenseNumber": "TN12345ABC",
    "status": "AVAILABLE",
    "maxShiftHours": 10,
    "createdAt": "2024-05-27T15:00:00"
}
```

---

## 📁 Project Structure
```
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
```

---

## ✅ Testing Status

| Feature | Status |
|---------|--------|
| Vehicle Registration | ✅ Tested |
| Vehicle Retrieval | ✅ Tested |
| Vehicle Update | ✅ Tested |
| Driver Registration | ✅ Tested |
| Driver Retrieval | ✅ Tested |
| Exception Handling | ✅ Tested |
| Database Connection | ✅ Tested |

---

## 🔧 Error Handling

| Exception | HTTP Status | Description |
|-----------|------------|-------------|
| ResourceNotFoundException | 404 | Resource not found |
| DuplicateResourceException | 400 | Duplicate entry |
| BusinessException | 400 | Business rule violation |
| General Exception | 500 | Unexpected error |

---

## 🚧 Future Enhancements

- [ ] JWT Authentication
- [ ] Route Optimization Algorithm
- [ ] Docker Containerization
- [ ] Swagger API Documentation
- [ ] Unit & Integration Tests

---

## 👨‍💻 Author

**Sivanagaraj**
- GitHub: [@sivanagaraj9629](https://github.com/sivanagaraj9629)

---

## 📄 License

This project is open source - MIT License.

---

**Status:** ✅ Complete & Tested  
**Version:** 1.0.0  
**Last Updated:** May 2026
