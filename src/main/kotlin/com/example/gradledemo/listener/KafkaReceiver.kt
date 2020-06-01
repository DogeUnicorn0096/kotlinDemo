package com.example.gradledemo.listener

import com.example.gradledemo.entity.UserEntity
import lombok.extern.slf4j.Slf4j
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

/**
 * 作者：薛晓波
 * 项目名：kafka-demo
 * 时间：2020/4/3  3:38 下午
 * 描述：
 */
@Component
@Slf4j
class KafkaReceiver {
    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @KafkaListener(topics = ["test2"])
    fun listen2(record: ConsumerRecord<*, *>) {
        log.error("msg = {}", record.value())
    }

    @KafkaListener(topics = ["user"])
    fun userListener(record: ConsumerRecord<String, Any>) {
        log.error("kafka receive: register success! ${record.value()}")
    }
}