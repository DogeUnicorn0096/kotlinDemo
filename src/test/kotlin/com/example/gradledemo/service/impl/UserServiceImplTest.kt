package com.example.gradledemo.service.impl

import com.example.gradledemo.entity.UserEntity
import com.example.gradledemo.repository.UserRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(MockitoExtension::class)

internal class UserServiceImplTest {
    @Mock
    lateinit var userRepository:UserRepository

    @InjectMocks
    lateinit var userServiceImpl: UserServiceImpl

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun register() {
        var b = userServiceImpl.register("1", "1")
    }

    @Test
    fun login() {
        var user1 = UserEntity(1, "sss", "sss", Date())
        var user2 = UserEntity(2, "aaa", "sss", Date())
        var user3 = UserEntity(3, "ccc", "sss", Date())

        var list = listOf(user1, user2, user3)
        list.groupBy { it.password }
    }
}