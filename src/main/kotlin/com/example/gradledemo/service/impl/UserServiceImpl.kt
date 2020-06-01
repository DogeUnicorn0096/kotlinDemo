package com.example.gradledemo.service.impl

import com.example.gradledemo.entity.UserEntity
import com.example.gradledemo.repository.UserRepository
import com.example.gradledemo.service.UserService
import org.apache.kafka.clients.producer.ProducerRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.converter.JsonMessageConverter
import org.springframework.kafka.support.converter.RecordMessageConverter
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.Resource
import javax.transaction.Transactional

@Transactional
@Service
class UserServiceImpl : UserService {
    @Autowired
    private lateinit var kafkaTemplate: KafkaTemplate<String, UserEntity>

    @Autowired
    private lateinit var userRepository: UserRepository

    override fun register(account: String, password: String): Boolean {
        val user = userRepository.findUserEntityByAccount(account)

//        如果查询到结果，证明用户已存在，返回false
        if (user != null) {
            return false
        }
//        用户名不重复，就保存新用户
        var newUser = UserEntity(null, account, password, null)
        userRepository.save(newUser)

//        kafka发送消息
        kafkaTemplate.send("user",newUser)
        return true

    }

    override fun login(account: String, password: String):UserEntity? {
        return userRepository.findUserEntityByAccountAndPassword(account, password)
    }
}