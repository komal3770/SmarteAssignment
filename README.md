# SmarteAssignment

## Project Pre-requisite 
- Spring Boot
- Spring Data JPA
- H2 Database
- JAVA 8
- MAVEN
- Swagger

## API Documentation & Test APIs
- URL : http://localhost:8080/SmarteAssignment/swagger-ui.html

## H2 Database
- URL : http://localhost:8080/SmarteAssignment/h2-console

## FUNCTIONALITY ACHIEVED

### Populate the database with dummy data for 20 employees divided between 2 departments
- Employee data from application.yml file
- On Bean initialization copying yaml file employee data & saved to database once application starts

### Create new Employee and associate with department
- API : http://localhost:8080/SmarteAssignment/employees

### Create new Department
- API : http://localhost:8080/SmarteAssignment/departments

### Find all employees by department & above given age
- API : http://localhost:8080/SmarteAssignment/operations/deptAndAgeAbove

### Find all employees by department, below given age & active status
- API : http://localhost:8080/SmarteAssignment/operations/deptAndAgeBelow

### Find all employees by department, below given age, active status & above CTC given
- API : http://localhost:8080/SmarteAssignment/operations/deptAndAgeBelowAndCtc