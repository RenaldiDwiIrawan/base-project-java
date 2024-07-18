# Base Project

## Overview
This is a base project template for a Spring Boot application that includes the following features:
- CRUD operations ✅ 
- Custom response handling ✅
- Logging ✅
- File interceptor [SOON]
- Caching API [SOON]
- RESTful API ✅
- Apache Kafka integration [SOON]
- Redis [SOON]
- Docker configuration ✅

<!--
## Table of Contents
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Features](#features)
  - [CRUD Operations](#crud-operations)
  - [Custom Response Handling](#custom-response-handling)
  - [Logging](#logging)
  - [File Interceptor](#file-interceptor)
  - [Caching](#caching)
  - [RESTful API](#restful-api)
  - [Kafka Integration](#kafka-integration)
  - [Redis](#redis)
  - [Docker](#docker)
- [Configuration](#configuration)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- 
-->

## Prerequisites
- Java 8 or higher
- Maven 3.6 or higher
- Docker (optional, for containerization)

## Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/RenaldiDwiIrawan/base-project-java.git
    ```

2. Build the project:
    ```bash
    mvn clean install
    ```

3. Build Dockerfile
   ```bash
   docker build -t base_project_renaldi:v1.0.1 .
   ```

4. Up Docker Compose
   ```bash
   docker-compose up -d
   ```
   
5. Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```

## API Documentation

- **Postman Collection**: [Download Here](https://drive.google.com/file/d/1_6c7tpL89bXEgSiKIT7qYjhsZ7KQOxE5/view?usp=sharing)
- **Swagger UI**: [Swagger Documentation](http://localhost:8088/swagger-ui/index.html#/Kampus)

## Features

### CRUD Operations
- Basic CRUD operations for managing entities.
- Example entities: `Mahasiswa`, `Jurusan`, `Matkul`.

### Custom Response Handling
- Custom response structure for consistent API responses.
- Global exception handling for managing errors and exceptions.

<!--
### File Interceptor
- Interceptor for handling file uploads and downloads.
- Example implementation for file validation and processing.

### Caching
- Caching using Spring Cache with support for multiple cache providers (e.g., Redis, Ehcache).
-->
### RESTful API
- RESTful endpoints for various operations.
- Postman documentation for API exploration and testing.

<!--
### Kafka Integration
- Kafka producer and consumer for asynchronous message processing.
- Example implementation for sending and receiving messages.
-->

### Docker
- Dockerfile for containerizing the application.
- Docker Compose configuration for managing dependencies (PostgreSQL).


## Configuration
- Configuration files located in `src/main/resources`:
  - `application.properties`
- Update configurations as needed for your environment.

## Usage
- Access Swagger UI for API documentation and testing:
    ```bash
    http://localhost:8088/swagger-ui.html
    ``` 
- Postman Collection: [Download Here](https://drive.google.com/file/d/1_6c7tpL89bXEgSiKIT7qYjhsZ7KQOxE5/view?usp=sharing)

- Example API endpoints:
  - `GET localhost:8088/base-project/getAllMahasiswa` - Retrieve all mahasiswa
  - `POST localhost:8088/base-project/addMahasiswa` - Create a new mahasiswa
  - `PUT localhost:8088/base-project/updateMahasiswaById/9` - Update an existing mahasiswa
  - `DELETE localhost:8088/base-project/deleteMahasiswaById/5` - Delete a mahasiswa

<!--
- Kafka integration example:
  - Send a message to Kafka topic: `POST /api/messages`
  - Consume messages from Kafka topic
-->

<!--
## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
-->
