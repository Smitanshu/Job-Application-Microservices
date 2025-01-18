# Job Management Microservices

This project is a Job Management System built using **Microservice Architecture** and **Spring Boot**. The system consists of several services that communicate with each other, manage job postings, handle company details, manage reviews, and more. The services are:

- **Company Service**
- **Config Server**
- **Gateway Service**
- **Job Service**
- **Job Service Default**
- **Review Service**

Each service is responsible for specific functionality such as job posting, company details, reviews, etc. All services communicate through REST APIs and utilize a range of technologies, including Docker, Zipkin for tracing, PostgreSQL, Eureka server for service discovery, Spring Boot Actuator for health checks, and more.

## Services Overview

- **Company Service**: Manages company data.
- **Config Server**: Provides configuration properties for all services.
- **Gateway Service**: Acts as an API Gateway, routing requests to the appropriate services.
- **Job Service**: Manages job posting, updating, deletion, and retrieval.
- **Job Service Default**: Default configuration of job services.
- **Review Service**: Manages reviews for companies and jobs.

## Technologies Used

- **Spring Boot**: For building microservices.
- **PostgreSQL**: Used for persistent storage.
- **Eureka Server**: For service discovery.
- **Docker**: Containerization of microservices.
- **Zipkin**: Distributed tracing for tracing requests across microservices.
- **Spring Cloud Gateway**: For routing requests to microservices.
- **Spring Boot Actuator**: For health checks.
- **Feign Client**: For inter-service communication.

## Setup and Running the Application

To run the microservices on your local machine, follow these steps:

### Prerequisites

- Java 17 or later
- Maven 3.8+ (for building the services)
- Docker (for containerization of services)
- PostgreSQL (for the database)
- Zipkin (for tracing)
- Eureka Server

### Step 1: Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/Smitanshu/Job-Application-Microservices.git
cd Job-Application-Microservices
