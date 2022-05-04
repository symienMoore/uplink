package com.uplink.enterprise.controllers

import com.uplink.enterprise.models.User
import com.uplink.enterprise.services.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/api")
class UserController(private val userService: UserService) {

    val resultNotification: String = ""

    @RequestMapping("/login")
    fun doUserLogin(@RequestBody user: User): ResponseEntity<User> {
        this.userService.createUser(user)
        return ResponseEntity(user, HttpStatus.CREATED)
    }

}