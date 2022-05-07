package com.uplink.enterprise.controllers

import com.uplink.enterprise.DTO.LoginDTO
import com.uplink.enterprise.DTO.RegisterDTO
import com.uplink.enterprise.models.User
import com.uplink.enterprise.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/api")
class UserController(@Autowired private val userService: UserService) {

    @PostMapping("/login")
    fun doUserLogin(@RequestBody userBody: LoginDTO, response: HttpServletResponse): ResponseEntity<Any> {
        var user: User? = this.userService.findByEmail(userBody.email)
            ?: return ResponseEntity.badRequest().body("Could not find user with that email, please try again.")
        if (user != null) {
            if (!user.comparePassword(userBody.password)) {
                return ResponseEntity.badRequest().body("invalid password!")
            }
        }
        val issuer = user?.id.toString()
        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 1000)) // 1 day
            .signWith(SignatureAlgorithm.HS512, "secret").compact()
        val cookie = Cookie("jwt", jwt)
        cookie.isHttpOnly = true
        response.addCookie(cookie)
        return ResponseEntity.ok("Successfully logged in!")
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