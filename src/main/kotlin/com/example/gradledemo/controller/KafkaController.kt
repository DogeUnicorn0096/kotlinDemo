package com.example.gradledemo.controller

import com.example.gradledemo.entity.Message
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.sql.Timestamp
import java.time.LocalDateTime
import javax.annotation.Resource
import kotlin.random.Random

/**
 * 作者：薛晓波
 * 项目名：kafka-provider
 * 时间：2020/4/3  4:10 下午
 * 描述：
 */
@RestController
class KafkaController {
    @Resource
    private lateinit var kafkaTemplate: KafkaTemplate<String, String>


    @GetMapping("/send3")
    fun send3(msg: String): String {
        kafkaTemplate.send("test2", msg)
        return msg
    }

    @GetMapping("/send1/{msg}")
    fun send1(@PathVariable msg: String): Message {
        val message = Message(Random(9).nextLong(), msg, Timestamp.valueOf(LocalDateTime.now()))
        kafkaTemplate.send("test2", message.toString())
        println(message)
        return message
    }
}