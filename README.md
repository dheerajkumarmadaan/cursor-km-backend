# Cursor KM Backend

Backend service for Cursor KM project built with Spring Boot.

## Tech Stack

- Java 21
- Spring Boot
- Gradle
- PostgreSQL
- Aerospike
- Kafka
- Prometheus
- Logback
- JUnit
- Spring Security

## Prerequisites

- JDK 21
- Gradle
- PostgreSQL
- Aerospike
- Kafka

## Setup & Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/dheerajkumarmadaan/cursor-km-backend.git
   cd cursor-km-backend
   ```

2. Build the project:
   ```bash
   ./gradlew clean build
   ```

3. Run the application:
   ```bash
   ./gradlew bootRun
   ```

The application will start on port 8080 by default.

## API Documentation

API documentation will be available at `http://localhost:8080/swagger-ui.html` when the application is running.

## Development Guidelines

- Follow SOLID principles
- Write unit tests for new features
- Keep methods under 50 lines
- Use appropriate exception handling with TTNException
- Follow the effective Java guidelines
- Implement proper logging
- Document public APIs

## Contributing

1. Create a feature branch
2. Commit your changes
3. Push to the branch
4. Create a Pull Request

## License

This project is licensed under the MIT License. 