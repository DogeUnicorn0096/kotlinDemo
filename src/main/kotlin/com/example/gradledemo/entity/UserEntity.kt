package com.example.gradledemo.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "user", schema = "public", catalog = "test1")
data class UserEntity(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(name = "id", nullable = false)
        var id: Long? = null,

        @Column(name = "account", nullable = false)
        var account: String? = null,

        @Column(name = "password", nullable = false)
        var password: String? = null,

        @CreatedDate
        @Column(name = "create_time", nullable = false)
        var createTime: Date? = null
) : Serializable

