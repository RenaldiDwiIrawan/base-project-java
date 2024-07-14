# Base Project

## Overview
This is a base project template for a Spring Boot application that includes the following features:
- CRUD operations ✅ 
- Custom response handling ✅
- Logging [SOON]
- File interceptor [SOON]
- Caching API [SOON]
- RESTful API ✅
- Apache Kafka integration [SOON]
- Redis [SOON]
- Docker configuration [SOON]

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
- Kafka (for Kafka integration)
- Redis

## Installation
1. Clone the repository:
    ```bash
    git clone (https://github.com/RenaldiDwiIrawan/base-project-java.git)
    ```

2. Build the project:
    ```bash
    mvn clean install
    ```
<!--
## Running the Application
1. Start Kafka and Zookeeper:
    ```bash
    docker-compose up -d
    ``` */
-->

2. Run the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```

## Features

### CRUD Operations
- Basic CRUD operations for managing entities.
- Example entities: `Mahasiswa`, `Jurusan`, `Matkul`.

### Custom Response Handling
- Custom response structure for consistent API responses.
- Global exception handling for managing errors and exceptions.

<!--
### Logging
- Logging configuration using Logback.
- Custom log format and log file rotation.

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

### Docker
- Dockerfile for containerizing the application.
- Docker Compose configuration for managing dependencies (e.g., Kafka, Zookeeper).

## Configuration
- Configuration files located in `src/main/resources`:
  - `application.properties`
  - `logback-spring.xml`
- Update configurations as needed for your environment.

## Usage
- Access Swagger UI for API documentation and testing:
    ```bash
    http://localhost:8080/swagger-ui.html
    ```

- Example API endpoints:
  - `GET /api/users` - Retrieve all users
  - `POST /api/users` - Create a new user
  - `PUT /api/users/{id}` - Update an existing user
  - `DELETE /api/users/{id}` - Delete a user

- Kafka integration example:
  - Send a message to Kafka topic: `POST /api/messages`
  - Consume messages from Kafka topic
-->

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
