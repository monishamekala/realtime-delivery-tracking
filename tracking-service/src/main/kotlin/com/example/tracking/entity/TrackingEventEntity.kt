package com.example.tracking.entity

import jakarta.persistence.*
import java.time.Instant
import java.util.*

@Entity
@Table(name = "tracking_events")
data class TrackingEventEntity(
    @Id
    @GeneratedValue
    val id: UUID? = null,

    @Column(nullable = false)
    val orderId: String,

    @Column(nullable = false)
    val latitude: Double,

    @Column(nullable = false)
    val longitude: Double,

    @Column(nullable = false)
    val timestamp: Instant,

    val createdAt: Instant? = Instant.now()
)
