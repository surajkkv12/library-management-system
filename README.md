# Library Management System

A RESTful Library Management System built using Spring Boot and MySQL.

---

# Features

- User Registration & Login
- Membership Management
- Add / View Books
- Borrow Book with validation
- REST APIs tested using Postman

---

# Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman

---

# Setup Instructions

1. Clone the repository:
git clone https://github.com/surajkkv12/library-management-system.git

2. Open in Eclipse / Spring Tool Suite

3. Configure database in application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=root
spring.datasource.password=Your_Password

4. Run the project:
Right click → Run as Spring Boot App

---

# API Endpoints

POST /users → Create user  
GET /users → Get all users  

POST /books → Add book  
GET /books → Get all books  

POST /borrow?userId=1&bookId=1&days=5  

---

# Testing

APIs tested using Postman  
Status: Working 

---

# Author

Sachin Vishwakarma
