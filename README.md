# 🚚 Fleet Management System

A Spring Boot REST API for managing fleet vehicles, drivers, and delivery tasks with MySQL database integration.

## ✨ Features

- ✅ Vehicle Management (CRUD operations)
- ✅ Driver Management with License Tracking
- ✅ Delivery Task Assignment & Tracking
- ✅ Delivery Status Management (UNASSIGNED → DISPATCHED → IN_TRANSIT → DELIVERED)
- ✅ Global Exception Handling
- ✅ Data Validation
- ✅ MySQL Database Integration

## 🛠️ Technology Stack

| Category | Technology |
|----------|-----------|
| Backend | Spring Boot 3.5.14 |
| Language | Java 17 |
| Database | MySQL 8.0 |
| ORM | Spring Data JPA / Hibernate |
| Build Tool | Maven |
| Utilities | Lombok |

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

## 🗃️ Database Schema

### Tables
- **vehicles** - Fleet vehicle information
- **drivers** - Driver profiles and licenses
- **delivery_tasks** - Delivery assignments

### Relationships
