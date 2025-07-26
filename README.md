# realtime-delivery-tracking

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
