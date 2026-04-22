# Library Management System (Spring Boot)

A RESTful Library Management System built using Spring Boot and MySQL.
This project provides APIs for managing users, books, borrowing/returning functionality, and membership validation.

---

# Features

# Basic APIs

* Get list of all users with details
* Get list of books with filters (category, status, name, author)
* User login
* Add book to library
* Update book status (available / taken)
* Check and update user membership

# Advanced APIs

* Borrow book with membership validation
* Return book functionality
* Track user book history (current + past books)
* Get most popular book categories (percentage-based reporting)

---

# Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

---

# How to Run the Project

# Clone Repository

```
git clone https://github.com/surajkkv12/library-management-system.git
```

# Configure Database

Open `src/main/resources/application.properties` and update:

```
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

# Run Application

```
mvn spring-boot:run
```

# Test APIs

Use Postman to test APIs on:

```
http://localhost:8080
```

---

# API Endpoints

# User APIs

* POST `/users` → Create user
* GET `/users` → Get all users
* GET `/users/{id}` → Get user details

# Book APIs

* POST `/books` → Add book
* GET `/books` → Get all books
* GET `/books/search` → Filter books

# Borrow APIs

* POST `/borrow?userId=1&bookId=1&days=5` → Borrow book
* POST `/return?userId=1&bookId=1` → Return book

---

# Business Logic Covered

* Membership validation before borrowing
* Book availability check
* Auto status update (available / taken)
* User borrowing tracking
* Category-based reporting

---

# Project Status

✔ Fully functional
✔ Database integrated
✔ APIs tested using Postman
✔ GitHub ready

---

# Author

**Suraj Vishwakarma**
