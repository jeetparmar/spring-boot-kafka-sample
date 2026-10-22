# Spring Boot Kafka REST API

This is a simple Spring Boot application that demonstrates producing and consuming events using Apache Kafka.

## 🚀 Tech Stack
- **Java 21**
- **Spring Boot 3.3.5**
- **Apache Kafka** (KRaft Mode)
- **Docker & Docker Compose**
- **SpringDoc OpenAPI (Swagger)**

## 🛠️ Getting Started

### 1. Prerequisites
- [Docker Desktop](https://www.docker.com/products/docker-desktop/) installed and running.
- [JDK 21](https://adoptium.net/) installed.
- Maven (provided via `./mvnw` wrapper).

### 2. Infrastructure Setup
Start the Kafka broker and the Kafka UI using Docker Compose:

```bash
docker compose up -d
```

This will start:
- **Kafka Broker:** Accessible internally via port `9092` and externally via `9094`.
- **Kafka UI:** Accessible at [http://localhost:8081](http://localhost:8081).

### 3. Run the Application
Start the Spring Boot application:

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.

## 📖 API Documentation

The application includes a Swagger UI for easy testing of the endpoints.
👉 **[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)**

### Endpoints

#### Produce a Kafka Event
**Endpoint:** `POST /kafka/publish`
**Query Param:** `message` (String)

Example using `curl`:
```bash
curl -X POST "http://localhost:8080/kafka/publish?message=HelloKafka"
```

## 🔍 Monitoring & Verification

### 1. Application Logs
When you send a message, check the application console. You should see:
- `Produced: HelloKafka` (from the Producer service)
- `Consumed: HelloKafka` (from the Consumer service)

### 2. Kafka UI
Visit **[http://localhost:8081](http://localhost:8081)** to:
- View the `my-topic` topic.
- Inspect the messages currently stored in the topic.
- Monitor the `my-group` consumer group.

## 🧹 Cleanup
To stop and remove the Kafka containers:
```bash
docker compose down
```
