package com.example.gradledemo.config

import com.example.gradledemo.entity.UserEntity
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.serialization.Deserializer
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

class JsonDeserializer : Deserializer<Any> {
    override fun deserialize(topic: String?, data: ByteArray?): Any {
        val mapper = ObjectMapper()
        return mapper.readValue(data, Any::class.java)
    }
}