repo/
├── .github/
│   └── workflows/
│       └── ci.yml
├── docker/
│   ├── kafka/
│   ├── redis/
│   └── cockroachdb/
├── k8s/
│   ├── deployment.yaml
│   ├── service.yaml
│   └── monitoring/
│       ├── prometheus.yaml
│       └── grafana.yaml
├── tracking-service/
│   ├── build.gradle.kts
│   ├── src/
│   │   └── main/kotlin/com/example/tracking/
│   │       ├── controller/
│   │       │   └── TrackingController.kt  # REST endpoint to receive GPS events
│   │       ├── service/
│   │       │   └── TrackingService.kt      # Core business logic
│   │       ├── kafka/
│   │       │   └── TrackingConsumer.kt     # Consumes GPS events from Kafka
│   │       ├── grpc/
│   │       │   └── TrackingGrpcService.kt  # gRPC endpoint for real-time updates
│   │       ├── redis/
│   │       │   └── RedisGeoCache.kt        # Redis-based geospatial storage
│   │       └── Application.kt              # Spring Boot main app
├── notification-service/
│   ├── build.gradle.kts
│   └── src/main/kotlin/com/example/notification/
│       ├── RabbitListener.kt               # Listens to RabbitMQ for async tasks
│       └── NotificationService.kt          # Sends out notifications
├── search-service/
│   ├── build.gradle.kts
│   └── src/main/kotlin/com/example/search/
│       ├── SearchController.kt             # REST search endpoint for admin
│       └── ElasticsearchService.kt         # Interfaces with Elasticsearch
├── docker-compose.yml                      # Local development orchestration
├── README.md                               # Project documentation
└── settings.gradle.kts

--- README.md ---

# Real-Time Delivery Tracking Platform

## Overview
A microservice-based real-time delivery tracking system using:
- **Kotlin**, **Spring Boot**, **Kafka**, **RabbitMQ**
- **Redis** (geospatial), **Elasticsearch**, **CockroachDB**
- Deployed via **Kubernetes (EKS)** with monitoring through **Prometheus** and **Grafana**

## Architecture
- **Tracking Service**: Streams GPS/order events via Kafka and gRPC
- **Notification Service**: Sends alerts (e.g., delivery updates) asynchronously via RabbitMQ
- **Search Service**: Enables admin search on delivery data via Elasticsearch

## Features
- Real-time GPS streaming and updates
- Geospatial caching with Redis
- Asynchronous notifications and invoicing
- Search by customer/order/location
- Scalable microservices architecture
- Monitored with Prometheus/Grafana

## How to Run
```bash
# Start locally with Docker Compose
$ docker-compose up --build

# Deploy to Kubernetes (example)
$ kubectl apply -f k8s/
```

## CI/CD
- GitHub Actions workflow in `.github/workflows/ci.yml`
- Auto builds, tests, and deploys services on push

## License
MIT
