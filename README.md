# Real-Time Delivery Tracking Platform

## About the Application
This is a real-time delivery tracking system designed to monitor and manage the movement of delivery orders across locations. It uses a microservices architecture to stream live location updates, send asynchronous notifications, and allow efficient admin-side search.

### What Makes It Different?
- Uses gRPC + Kafka to stream thousands of location updates per second with low latency.
- Combines Redis GEO caching for fast location queries and Elasticsearch for powerful full-text admin search.
- Uses CockroachDB, a distributed SQL database, for high resilience and scalability.
- Includes a React-based Admin Dashboard with live charts and tracking map.

### Key Features
- Live GPS tracking via Kafka and gRPC
- Asynchronous notifications and invoicing with RabbitMQ
- Real-time admin search with Elasticsearch
- Redis geospatial queries for nearest delivery units
- Monitored with Prometheus & Grafana
- Admin dashboard UI with Tailwind, Recharts, React

---

## Tech Stack (with Versions & Features)

### Backend (Microservices)
| Technology     | Version   | Role |
|----------------|-----------|------|
| Kotlin         | 1.9+      | Main programming language |
| Spring Boot    | 3.x       | REST APIs, gRPC, Messaging |
| Kafka          | 3.5+      | Location event streaming |
| RabbitMQ       | 3.x       | Background async tasks |
| Redis          | 7.x       | GEO spatial caching |
| Elasticsearch  | 8.x       | Full-text search indexing |
| CockroachDB    | 23.x      | Distributed SQL store |
| gRPC           | 1.54+     | Efficient binary streaming protocol |

### Infrastructure
| Tool        | Role |
|-------------|------|
| Docker      | Containerized development |
| Kubernetes (EKS) | Cloud deployment |
| Prometheus  | Metrics collection |
| Grafana     | Monitoring dashboards |
| GitHub Actions | CI/CD automation |

### Frontend (Admin Dashboard)
| Technology     | Version | Role |
|----------------|---------|------|
| React          | 18+     | SPA Admin UI |
| Tailwind CSS   | 3+      | Styling framework |
| Recharts       | 2+      | Status charts/graphs |
| gRPC-Web       | Latest  | Real-time data feed support |
| Vite           | Latest  | Fast dev server |

---

## Data Structures, Concepts & Algorithms Used
- Kafka Topics for scalable event streaming
- Redis GEOHASH for location indexing and radius queries
- CockroachDB primary key indexing, foreign key constraints
- Elasticsearch inverted index for admin search
- gRPC streams for binary-efficient data transfer
- Charting algorithms via Recharts Pie/Bar Chart
- Stateful microservices with persistent layers
- Pub/Sub patterns for loosely coupled services

---

## How to Run

### Local (Docker Compose)
```bash
# From project root
$ docker-compose up --build
```

### Kubernetes (EKS / Minikube)
```bash
kubectl apply -f k8s/
```

### Frontend Dashboard
```bash
cd dashboard
npm install
npm run dev  # Vite will run on http://localhost:5173
```

---

## Future Scope
- Mobile app version (React Native / Flutter)
- ML-based ETA predictions
- Live delivery route maps with Leaflet / Mapbox
- Multi-region Kafka clusters
- Webhooks + external integrations (Twilio, SendGrid)
- WebSocket-based real-time user updates
- CI/CD with GitHub Actions + Helm charts for production

---

## License
MIT License
