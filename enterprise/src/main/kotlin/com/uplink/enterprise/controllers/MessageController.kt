package com.uplink.enterprise.controllers

import com.uplink.enterprise.DTO.MessageDTO
import com.uplink.enterprise.models.Message
import com.uplink.enterprise.models.User
import com.uplink.enterprise.repositories.MessageRepository
import com.uplink.enterprise.services.MessageService
import com.uplink.enterprise.services.UserService
import io.jsonwebtoken.Jwts
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/api")
class MessageController(
    @Autowired private val messageService: MessageService,
    @Autowired private val userService: UserService
) {

    @RequestMapping("/create-message")
    fun addMessage(@CookieValue("jwt") jwt: String?,
                   @RequestBody message: Message,
                   request: HttpServletRequest): ResponseEntity<Any> {
        try {
            if(jwt == null) {
                return ResponseEntity.status(401).body("unauthenticated!")
            }
//            val userId = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body
//            val foundUser = this.userService.getById(userId.issuer.toString())
//            println(foundUser)
//              val newMessage = this.messageService.createMessage(message)
//                println(newMessage)
            val body = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body
            val user: User? = this.userService.getById(body.issuer.toString())
            val createdMessage: Message = this.messageService.createMessage(message)
            user?.messages?.add(createdMessage)
            return ResponseEntity.ok(user)
        } catch (e: Exception) {
            return ResponseEntity.status(401).body(e.message)
        }

    }
}