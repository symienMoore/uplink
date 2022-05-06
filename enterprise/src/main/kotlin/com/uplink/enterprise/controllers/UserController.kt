package com.uplink.enterprise.controllers

import com.uplink.enterprise.DTO.LoginDTO
import com.uplink.enterprise.DTO.RegisterDTO
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

    @RequestMapping("/login")
    fun doUserLogin(@RequestBody userBody: LoginDTO): ResponseEntity<User> {
        var user: User = User()
        user.email = userBody.email
        return ResponseEntity(user, HttpStatus.CREATED)
    }

    @RequestMapping("/signup")
    fun doUserSignin(@RequestBody body: RegisterDTO): ResponseEntity<User> {
            var user: User = User()
            user.name = body.name
            return ResponseEntity(user, HttpStatus.CREATED)
    }

}