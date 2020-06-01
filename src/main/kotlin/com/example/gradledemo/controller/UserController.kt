package com.example.gradledemo.controller

import com.example.gradledemo.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@Api(value = "用户", tags = ["用户"])
@RestController("user")
class UserController {
    @Autowired
    private lateinit var userService: UserService

    @ApiOperation("注册")
    @PostMapping("register")
    fun register(account: String, password: String): String {
        //返回是否注册成功
        val isSuccess = userService.register(account, password)
        return when {
            isSuccess -> "register success"
            else -> "register fail"
        }
    }

    @ApiOperation("登录")
    @GetMapping("login")
    fun login(account: String, password: String): String {
//        return when (val user = userService.login(account, password)) {
////            根据是否查询到用户，判断是否登录成功
//            null -> "login fail"
//            else -> "login success! $user"
//        }
        return userService.login(account, password)
                ?.let { "login success! $it" } ?: "account or password incorrect"
    }
}