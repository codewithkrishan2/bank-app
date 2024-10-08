# Bank Management Application

## Overview

This is a Spring Boot-based web application for managing banks, their branches, and the services they offer. The application includes both web-based views using Thymeleaf and a RESTful API for accessing data.

## Features

- Display a list of banks with their branches and services.
- View details of branches and the services offered by each bank.
- User-friendly interface with premium UI design.
- REST API support for retrieving bank, branch, and service details.

## Technologies Used

- **Spring Boot**: Backend framework for building Java-based applications.
- **Thymeleaf**: Template engine for rendering HTML pages.
- **Bootstrap**: CSS framework for responsive and mobile-first front-end design.
- **Java 21**: Programming language used for the application logic.
- **Maven**: Build automation tool used to manage project dependencies.

## Setup

1. **Clone the Repository**:
    ```bash
    git clone https://github.com/yourusername/bank-management-app.git
    cd bank-management-app
    ```

2. **Build and Run the Project**:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

3. **Access the Application**:
    - Web Interface: [https://bank-app-production-7671.up.railway.app/bank/list](https://bank-app-production-7671.up.railway.app/bank/list)
    - API Interface: [https://bank-app-production-7671.up.railway.app/api/bank/list](https://bank-app-production-7671.up.railway.app/api/bank/list)
    - Web Interface: [http://localhost:8080/bank/list](http://localhost:8080/bank/list)
    - API Endpoints 1: [http://localhost:8080/api/bank/list](http://localhost:8080/api/bank/list)
    - API Endpoints 2: [http://localhost:8080/api/bank/branch/{bankName}](http://localhost:8080/api/bank/branch/{bankName})
    - API Endpoints 3: [http://localhost:8080/api/bank/branch/{bankName}](http://localhost:8080/api/bank/branch/{bankName})

## Project Structure

```plaintext
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── bank/
│   │           ├── controller/
│   │           │   ├── BankController.java
│   │           │   ├── BankRestController.java
│   │           ├── service/
│   │           │   ├── BankService.java
│   │           │   ├── BankServiceImpl.java
│   │           │   ├── BranchService.java
│   │           │   ├── BranchServiceImpl.java
│   │           │   ├── ServiceOfBankService.java
│   │           │   ├── ServiceOfBankServiceImpl.java
│   │           ├── exception/
│   │           │   ├── BankNotFoundException.java
│   │           ├── model/
│   │           │   ├── Bank.java
│   │           │   ├── Branch.java
│   │           │   ├── Services.java
│   │           ├── repository/
│   │           │   ├── BankRepo.java
│   │           │   ├── BranchRepo.java
│   │           │   ├── ServicesRepo.java
│   └── resources/
│       ├── templates/
│       │   ├── banks.html
│       │   ├── error.html
│       │   ├── branches.html
│       │   ├── services.html
│       ├── application.properties
```
