package com.uplink.warbird.controllers

import com.uplink.warbird.kafkaConfig.KafkaTopicConfig
import com.uplink.warbird.models.User
import com.uplink.warbird.services.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class UserController(private val service: UserService, private val kafkaTopicConfig: KafkaTopicConfig) {

    @PostMapping
    fun registerUser() {
        kafkaTopicConfig.createTopic()
    }
}