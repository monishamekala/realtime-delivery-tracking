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
