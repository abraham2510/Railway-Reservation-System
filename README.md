# 🚆 Railway Reservation System

This is a **RESTful API-based Railway Reservation System** built with **Java** and **Spring Boot**. The system enables users to manage trains, passengers, and reservations with full CRUD functionality, along with seat availability checks and reservation status tracking.

---

## 📌 Features

### 🔹 Train Management
- Add, update, delete trains
- View train details
- Search trains by source & destination

### 🔹 Passenger Management
- Add, update, delete passengers
- View passenger details

### 🔹 Reservation Management
- Book and cancel reservations
- View reservations by train or passenger
- Check seat availability
- Get reservation status

---

## 📁 REST API Endpoints

### 🚄 **TrainModel API**
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/trains` | Add a new train |
| GET | `/api/trains` | Get all trains |
| GET | `/api/trains/{id}` | Get train by ID |
| PUT | `/api/trains/{id}` | Update train details |
| DELETE | `/api/trains/{id}` | Delete train |
| GET | `/api/trains/search?source={source}&destination={destination}` | Search trains by route |

### 👤 **PassengerModel API**
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/passengers` | Add a new passenger |
| GET | `/api/passengers` | Get all passengers |
| GET | `/api/passengers/{id}` | Get passenger by ID |
| PUT | `/api/passengers/{id}` | Update passenger details |
| DELETE | `/api/passengers/{id}` | Delete passenger |

### 🎟️ **ReservationModel API**
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/reservations` | Create a reservation |
| GET | `/api/reservations` | Get all reservations |
| GET | `/api/passengers/{id}/reservations` | Get reservations by passenger |
| GET | `/api/trains/{id}/reservations` | Get reservations by train |
| PUT | `/api/reservations/{id}/cancel` | Cancel reservation |
| GET | `/api/trains/{id}/availability?date={travelDate}` | Check seat availability |
| GET | `/api/reservations/{id}/status` | Get reservation status |

---

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA (Hibernate)**
- **MySQL** *(or H2 for dev/testing)*
- **Maven**
- **Postman** *(for testing)*

---

## 🚀 Getting Started

### ✅ Prerequisites
- Java 17+
- Maven
- MySQL (or H2)

