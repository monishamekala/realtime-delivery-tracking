package com.example.notification.entity

import jakarta.persistence.*
import java.time.Instant
import java.util.*

@Entity
@Table(name = "notifications")
data class NotificationEntity(
    @Id
    @GeneratedValue
    val id: UUID? = null,

    @Column(nullable = false)
    val orderId: String,

    @Column(nullable = false)
    val message: String,

    val status: String = "pending",

    val createdAt: Instant? = Instant.now()
)

