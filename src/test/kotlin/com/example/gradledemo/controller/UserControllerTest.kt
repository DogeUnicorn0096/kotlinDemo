package com.example.gradledemo.controller

import com.example.gradledemo.GradleDemoApplication
import org.junit.experimental.results.ResultMatchers
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.kafka.test.context.EmbeddedKafka
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.transaction.annotation.Transactional

@DisplayName("测试-用户登录信息")
@SpringBootTest(classes = [GradleDemoApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class)
@AutoConfigureMockMvc
@Transactional

internal class UserControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    var logger: Logger = LoggerFactory.getLogger(javaClass)


    @DisplayName("用户登录成功测试")
    @ParameterizedTest(name = "用户登录成功测试")
    @CsvSource(
            "root,root",
            "root1,root",
            "xuexiaobo,root",
            "admin,admin"
    )
    fun `Login Test`(account: String, password: String) {
        val req = MockMvcRequestBuilders.get("/login")
                .param("account", account)
                .param("password", password)

        val result = mockMvc.perform(req)
                .andExpect { assertEquals(it.response.status, HttpStatus.OK.value()) }
                .andExpect { assertEquals(it.response.contentAsString.subSequence(0, 14), "login success!") }
                .andReturn()

        val content = result.response.contentAsString
        logger.info("Response:context=$content")
    }

    @Test
    @DisplayName("注册成功测试")
    fun `Register Test`() {
        val req = MockMvcRequestBuilders.post("/register")
                .param("account", "root1024")
                .param("password", "root")
        mockMvc.perform(req).andExpect { assertEquals(it.response.contentAsString, "register success") }
    }


    @BeforeEach
    fun testBefore() {
        println("before================")
    }

    @AfterEach
    fun testAfter() {
        println("after=================")
    }

    companion object {
        @BeforeAll
        fun method() {
            println("BeforeAll====================")
        }
    }
}