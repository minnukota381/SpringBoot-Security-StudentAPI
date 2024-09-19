# SpringBoot-Security-StudentAPI

## Overview
This is a Spring Boot project that demonstrates role-based access control (RBAC) using Spring Security. It provides a REST API for managing student records with CRUD operations and leverages `InMemoryUserDetailsManager` for user authentication.

## Features
- Role-based access control (Admin and User roles)
- RESTful endpoints for managing students
- Password encryption using BCrypt
- In-memory authentication for user management
- CRUD operations for `Students` entity

## Technologies Used
- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL (can be configured as needed)
- BCryptPasswordEncoder

## Endpoints

### Admin Role:
- `POST /students/add` - Add a new student (Admin only)
- `PUT /students/update/{id}` - Update student details (Admin only)
- `DELETE /students/delete/{id}` - Delete a student (Admin only)

### User Role:
- `GET /students` - View all students (User/ Admin)
- `GET /students/{id}` - View a student by ID (User/ Admin)

## Setup Instructions

1. Clone the repository:
    ```bash
    git clone https://github.com/minnukota381/SpringBoot-Security-StudentAPI.git
    ```

2. Open the project in your IDE (e.g., IntelliJ or Spring Tool Suite).

3. Configure the MySQL database in `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    ```

4. Run the application.

5. Access the API using the following user credentials:
   - Admin:
     - Username: `admin`
     - Password: `admin123`
   - User:
     - Username: `user`
     - Password: `12345`

## Security Configuration
- **Admin Role**: Can create, update, and delete student records.
- **User Role**: Can view student records.

The security is managed by `SecurityConfig` class, which defines access rules for specific endpoints based on user roles.

## License
This project is licensed under the MIT License.
