package com.uplink.enterprise.controllers

import com.uplink.enterprise.DTO.LoginDTO
import com.uplink.enterprise.DTO.RegisterDTO
import com.uplink.enterprise.models.User
import com.uplink.enterprise.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/api")
class UserController(@Autowired private val userService: UserService) {

    @PostMapping("/login")
    fun doUserLogin(@RequestBody userBody: LoginDTO): ResponseEntity<Any> {
        var user: User? = this.userService.findByEmail(userBody.email)
            ?: return ResponseEntity.badRequest().body("Could not find user with that email, please try again.")
        return ResponseEntity(user, HttpStatus.CREATED)
    }

    @PostMapping("/signup")
    fun doUserSignin(@RequestBody body: RegisterDTO): ResponseEntity<User> {
            var user: User = User()
            user.name = body.name
            user.username = body.username
            user.email = body.email
            user.password = body.password
            return ResponseEntity.ok(this.userService.createUser(user))
    }

    @RequestMapping("/test")
    fun runTest(): String {
        return "may the force be with you"
    }

}