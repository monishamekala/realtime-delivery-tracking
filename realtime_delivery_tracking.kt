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
