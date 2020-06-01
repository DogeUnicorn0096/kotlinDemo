package com.example.gradledemo.service.impl

import com.example.gradledemo.entity.Message
import com.example.gradledemo.repository.MessageRepository
import com.example.gradledemo.service.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageServiceImpl : MessageService {
    @Autowired
    private lateinit var messageRepository: MessageRepository

    override fun findAll(): MutableList<Message> {
        return messageRepository.findAll()
    }

    override fun findById(id: Long): Message {
        val message = messageRepository.findById(id)
        return message.get()
    }

    override fun save(message: Message) {
        messageRepository.save(message)
    }

    override fun deleteById(id: Long) {
        messageRepository.deleteById(id)
    }
}