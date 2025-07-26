package com.example.tracking.grpc

import net.devh.boot.grpc.server.service.GrpcService
import com.example.grpc.TrackingServiceGrpcKt
import com.example.grpc.TrackingRequest
import com.example.grpc.TrackingResponse
import org.slf4j.LoggerFactory

@GrpcService
class TrackingGrpcService : TrackingServiceGrpcKt.TrackingServiceCoroutineImplBase() {

    private val logger = LoggerFactory.getLogger(TrackingGrpcService::class.java)

    override suspend fun sendTracking(request: TrackingRequest): TrackingResponse {
        logger.info("Received gRPC tracking request: ${request.orderId} @ (${request.latitude}, ${request.longitude})")

        // Here you’d call TrackingService or Redis, Kafka, etc.

        return TrackingResponse.newBuilder()
            .setStatus("Received ${request.orderId}")
            .build()
    }
}
