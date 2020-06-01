package com.example.gradledemo.repository

import com.example.gradledemo.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findUserEntityByAccount(account: String): UserEntity?

    fun findUserEntityByAccountAndPassword(account: String, password: String): UserEntity?
}