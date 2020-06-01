package com.example.gradledemo.service

import com.example.gradledemo.entity.UserEntity
import java.util.*

interface UserService {
    fun register(account: String, password: String): Boolean
    fun login(account: String, password: String): UserEntity?
}