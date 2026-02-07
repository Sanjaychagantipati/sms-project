# 🎓 Student Management System

A full-stack Student Management System built using Spring Boot, React, PostgreSQL, and Docker.

---

## 🚀 Features

- JWT Authentication
- Role Based Access (ADMIN, TEACHER, STUDENT)
- Student CRUD
- Course Management
- Enrollment
- Attendance & Marks
- Swagger API Documentation
- Dockerized Deployment

---

## 🛠 Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL

### Frontend
- React
- Axios

### DevOps
- Docker
- Docker Compose

---

## 🏗 Architecture

Controller → Service → Repository → Database

---

## ▶ Run Locally (Docker)

```bash
mvn clean package -DskipTests
docker compose up --build
```

---

## ▶ Run Backend

Go inside backend folder:

```bash
cd student-management-system
```

Run:

```bash
mvnw spring-boot:run
```

Swagger:
http://localhost:8088/swagger-ui.html

---

## ▶ Run Frontend

Go inside frontend folder:

```bash
cd sms-frontend
```

Run:

```bash
npm install
npm start
```

Frontend:
http://localhost:3000

---

## 👨‍💻 Author

Sanjay Chagantipati