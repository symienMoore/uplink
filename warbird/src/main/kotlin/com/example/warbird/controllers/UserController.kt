package com.example.warbird.controllers

import com.example.warbird.services.UserService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class UserController(private val service: UserService) {
}