package com.example.tracking.redis

import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.connection.RedisGeoCommands
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class RedisGeoCache(
    private val redisTemplate: StringRedisTemplate
) {
    private val redisKey = "order-locations"

    fun cacheLocation(orderId: String, latitude: Double, longitude: Double) {
        val ops = redisTemplate.opsForGeo()
        ops.add(redisKey, RedisGeoCommands.GeoLocation(orderId, org.springframework.data.geo.Point(longitude, latitude)))

        // Optional: set expiration to auto-clean stale data
        redisTemplate.expire(redisKey, 1, TimeUnit.DAYS)
    }
}

@Service
class RedisGeoCache(
    private val redisTemplate: StringRedisTemplate
) {
    private val key = "vehicles"

    fun getAllVehicleLocations(): List<VehicleLocation> {
        val ops = redisTemplate.opsForGeo()
        val members = redisTemplate.opsForSet().members(key) ?: return emptyList()

        return members.mapNotNull { id ->
            val coords = ops.position(key, id)?.firstOrNull()
            val orderId = redisTemplate.opsForHash<String, String>().get("vehicle:order", id)
            coords?.let {
                VehicleLocation(
                    id = id,
                    lat = it.y,
                    lng = it.x,
                    orderId = orderId ?: "unknown"
                )
            }
        }
    }

    // Assume vehicle:order is a Redis hash mapping vehicle ID → order ID
}