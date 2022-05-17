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
    fun addMessage(@CookieValue("jwt") jwt: String?, @RequestBody body: Message): ResponseEntity<Any> {
        var message: Message = Message()
        message.messageContent = body.messageContent
        try {
            if(jwt == null) {
                return ResponseEntity.status(401).body("unauthenticated!")
            }
            val jwtbody = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body.issuer.toString()
            val user: User? = this.userService.getById(jwtbody)
            user?.messages?.add(message)
            // adding the user id to user field on message
            if (user != null) {
                message.user = user
            }
            this.messageService.createMessage(message)

            return ResponseEntity.ok(user?.messages)
        } catch (e: Exception) {
            return ResponseEntity.status(401).body(e.message)
        }

    }
}