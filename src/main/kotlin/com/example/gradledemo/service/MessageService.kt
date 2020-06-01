package com.example.gradledemo.service

import com.example.gradledemo.entity.Message

interface MessageService {
    fun findAll(): MutableList<Message>
    fun findById(id: Long): Message
    fun save(message: Message)
    fun deleteById(id: Long)
}