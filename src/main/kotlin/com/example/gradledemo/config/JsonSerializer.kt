package com.example.gradledemo.config

import com.example.gradledemo.entity.UserEntity
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Serializer

class JsonSerializer : Serializer<Any> {
    override fun serialize(topic: String?, data: Any?): ByteArray {
        return ObjectMapper().writeValueAsBytes(data)
    }
}