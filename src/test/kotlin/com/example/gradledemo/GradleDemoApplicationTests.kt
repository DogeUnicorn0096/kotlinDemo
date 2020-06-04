//package com.example.gradledemo
//
//import com.example.gradledemo.entity.UserEntity
//import com.example.gradledemo.repository.UserRepository
//import kafka.server.ClientQuotaManager
//import org.junit.Assert
//import org.junit.jupiter.api.Test
//import org.junit.runner.RunWith
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.test.context.ActiveProfiles
//import org.springframework.test.context.junit4.SpringRunner
//import java.util.*
//import kotlin.random.Random
//
//@RunWith(SpringRunner::class)
//@ActiveProfiles("test")
//@SpringBootTest
//class GradleDemoApplicationTests {
//
//    @Autowired
//    private lateinit var userRepository: UserRepository
//    @Test
//    fun save() {
//        var user = UserEntity(null, Random.nextInt().toString(),
//                Random.nextInt().toString(), null)
//        var save = userRepository.save(user)
//        println(save.toString())
//        Assert.assertNotNull(user.id)
//
//    }
//
//
//}
