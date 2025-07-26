package com.example.notification

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class NotificationService {
    private val logger = LoggerFactory.getLogger(NotificationService::class.java)

    fun sendNotification(payload: String) {
        // Placeholder for actual notification logic (email, push, etc.)
        logger.info("Sending notification: {}", payload)
    }
}
