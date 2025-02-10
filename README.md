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
```



### Step 2: Build the Services

To build each service individually, run the following commands:

```bash
cd companyms
mvn clean install
cd ../configServer
mvn clean install
cd ../gateway
mvn clean install
cd ../jobms
mvn clean install
cd ../reviewms
mvn clean install
```


Step 4: Access the Services
Once the services are running, you can access them through the following endpoints:

Company Service: http://localhost:8081
Config Server: http://localhost:config-server
Gateway Service: http://localhost:8084
Job Service: http://localhost:9082
Review Service: http://localhost:8083
Step 5: Test the APIs with Postman
You can test the API by making the following GET request:

Example GET Request:
bash
Copy
Edit
GET http://localhost:8084/jobs
Response (JSON):

json
Copy
Edit
[
    {
        "id": 1,
        "title": "SWE Id: ",
        "maxSalary": "1200",
        "minSalary": "80000",
        "description": "Responsible for developing and maintaining software applications.",
        "location": "Pune",
        "company": {
            "id": 1,
            "name": "Company with id 1",
            "description": "Service Provider"
        },
        "reviews": [
            {
                "id": 1,
                "title": "Great Product review 8 for company",
                "description": "The product quality is excellent and exceeded expectations.",
                "rating": 4.5
            },
            {
                "id": 2,
                "title": "Great Product review 8 for company",
                "description": "The product quality is excellent and exceeded expectations.",
                "rating": 4.5
            }
        ]
    }
]
Step 6: Health Check and Monitoring
Spring Boot Actuator provides health check endpoints for each service:

Company Service: http://localhost:8081/actuator/health
Job Service: http://localhost:9082/actuator/health
Review Service: http://localhost:8083/actuator/health
Gateway Service: http://localhost:8084/actuator/health
You can also access detailed health information and other metrics using Spring Boot Actuator.

Step 7: Zipkin for Tracing
You can use Zipkin to trace requests across the microservices:

Zipkin Dashboard: http://localhost:9411
Here, you can view the traces and analyze the flow of requests between services.

Step 8: Service Discovery via Eureka
Eureka provides service discovery. You can view the registered services via the Eureka dashboard:

Eureka Dashboard: http://localhost:8761/eureka/
