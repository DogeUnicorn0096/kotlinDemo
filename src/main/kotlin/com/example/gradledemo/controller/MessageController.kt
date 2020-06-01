package com.example.gradledemo.controller

import com.example.gradledemo.entity.Message
import com.example.gradledemo.service.MessageService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Api(value = "消息curd", tags = ["消息"])
@RestController
@RequestMapping("/message")
class MessageController {
    @Autowired
    private lateinit var messageService: MessageService

    @ApiOperation("查询所有消息")
    @GetMapping("/findAll")
    fun findAll(): MutableList<Message> {
        return messageService.findAll()
    }

    @ApiOperation("根据id查询消息")
    @GetMapping("/findById")
    fun findById(id: Long): Message {
        return messageService.findById(id)
    }

    @ApiOperation("保存一条消息")
    @ApiImplicitParam(name = "message", value = "消息实体类", required = true, dataType = "Message")
    @PostMapping("/insert")
    fun save(@RequestBody message: Message): String {
        messageService.save(message)
        return "insert success"
    }

    @ApiOperation("根据id删除一条消息")
    @PostMapping("/deleteById")
    fun deleteById(id: Long): String {
        messageService.deleteById(id)
        return "delete success"
    }
}