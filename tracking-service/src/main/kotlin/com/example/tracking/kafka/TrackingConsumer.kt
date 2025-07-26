package com.example.tracking.kafka

import com.example.tracking.controller.TrackingEvent
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class TrackingConsumer {

    private val logger = LoggerFactory.getLogger(TrackingConsumer::class.java)
    private val objectMapper = jacksonObjectMapper()

    @KafkaListener(topics = ["tracking-events"], groupId = "tracking-service")
    fun consume(message: String) {
        try {
            val event: TrackingEvent = objectMapper.readValue(message)
            logger.info("Consumed tracking event from Kafka: {}", event)

            // You can invoke downstream logic here if needed
        } catch (ex: Exception) {
            logger.error("Failed to deserialize tracking event", ex)
        }
    }
}
