package com.example.gradledemo.config

import com.example.gradledemo.entity.UserEntity
import org.apache.kafka.clients.producer.ProducerConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

//@Configuration
//class KafkaConfig {
//    @Bean
//    fun jsonKafkaTemplate():KafkaTemplate<String,UserEntity>{
//        val props = mutableMapOf<String,Any>()
//        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG]="com.example.gradledemo.config.JsonSerializer"
//
//        val pf:DefaultKafkaProducerFactory<String,UserEntity> = DefaultKafkaProducerFactory(props)
//        return KafkaTemplate(pf)
//    }
//
//}