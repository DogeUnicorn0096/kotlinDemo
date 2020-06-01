package com.example.gradledemo.entity

import org.hibernate.annotations.CreationTimestamp
import java.io.Serializable
import java.sql.Timestamp
import javax.persistence.*

/**
 * 作者：薛晓波
 * 项目名：kafka-demo
 * 时间：2020/4/3  3:27 下午
 * 描述：
 */
@Entity
@Table(name = "message")
data class Message(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                   var id: Long? = null,

                   @Column(name = "msg")
                   var msg: String? = null,

                   @Column(name = "send_time")
                   @CreationTimestamp
                   var sendTime: Timestamp? = null):Serializable