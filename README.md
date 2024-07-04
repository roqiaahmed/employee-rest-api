# Employee Management Web Service

This project is a web service for managing employee data using Spring Boot, JPA, and H2 database. The service provides RESTful endpoints to perform CRUD operations on employee records.

## Technologies Used

- Spring Boot: Framework to simplify the development of Spring applications.
- Spring Data JPA: Provides integration with JPA for database operations.
- H2 Database: In-memory database for rapid development and testing.

## Getting Started

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/roqiaahmed/employee-rest-api.git
    cd employee-management-web-service

   ```

2. **Build the project:**:

   ```bash
    ./mvnw clean install
   ```

3. **Run the application**:

   ```bash
    ./mvnw spring-boot:run
   ```

4. **Access H2 Console**:

   Open your browser and go to http://localhost:8080/h2-console to access the H2 database console.

5. **Documentation**:
   The API documentation (Swagger) can be accessed at /api/v1/docs

## API Endpoints

# Get All Employees

- URL: /api/v1/employees
- Method: GET
- Response: JSON array of employee objects.

# Get Employee by ID

- URL: /api/v1/employees/{id}
- Method: GET
- Response: JSON object of the employee.

# Add New Employee

- URL: /api/v1/employees
- Method: POST
- Request Body: JSON object of the new employee
- Response: JSON object of the created employee.

# Update Employee

- URL: /api/v1/employees/{id}
- Method: PUT
- Request Body: JSON object of the employee with updated data.
- Response: JSON object of the updated employee.

# Delete Employee

- URL: /api/v1/employees/{id}
- Method: DELETE
- Response: Response: HTTP status indicating the result of the operation.

# Contributors

- roqiaahmed
