package com.example.notification

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import org.slf4j.LoggerFactory

@Component
class NotificationListener(
    private val notificationService: NotificationService
) {
    private val logger = LoggerFactory.getLogger(NotificationListener::class.java)

    @RabbitListener(queues = ["notifications"])
    fun handleNotification(message: String) {
        logger.info("Received message from RabbitMQ: {}", message)
        notificationService.sendNotification(message)
    }
}
