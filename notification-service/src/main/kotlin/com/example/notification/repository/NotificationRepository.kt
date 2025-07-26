package com.example.notification.repository

import com.example.notification.entity.NotificationEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface NotificationRepository : JpaRepository<NotificationEntity, UUID>
