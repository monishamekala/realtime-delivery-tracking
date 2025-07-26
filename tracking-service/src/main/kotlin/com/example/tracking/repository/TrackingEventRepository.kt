package com.example.tracking.repository

import com.example.tracking.entity.TrackingEventEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TrackingEventRepository : JpaRepository<TrackingEventEntity, UUID>

