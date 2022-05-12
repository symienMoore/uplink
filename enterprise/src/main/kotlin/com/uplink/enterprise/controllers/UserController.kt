package com.uplink.enterprise.controllers

import com.uplink.enterprise.DTO.LoginDTO
import com.uplink.enterprise.DTO.RegisterDTO
import com.uplink.enterprise.models.User
import com.uplink.enterprise.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpServletRequest

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
        //TODO: set up a class to handle this
        val issuer = user?.id.toString()
        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 1000))
            .signWith(SignatureAlgorithm.HS512, "secret").compact()
        val cookie = Cookie("jwt", jwt)
        cookie.isHttpOnly = false
//        set in prod
//        cookie.secure = true
        response.addCookie(cookie)
        return ResponseEntity.ok(cookie)
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

    @RequestMapping("/user-profile")
    fun user(@CookieValue("jwt") jwt: String?, request: HttpServletRequest): ResponseEntity<Any> {
        println(jwt)
        println(request.toString())
       try {
           if (jwt == null) {
               return ResponseEntity.status(401).body("unauthenticated!")
           }
            val body = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body
            return ResponseEntity.ok(this.userService.getById(body.issuer.toString()))
       } catch (e: Exception) {
           return ResponseEntity.status(401).body("unauthenticated")
       }
    }

   @PostMapping("logout")
   fun logout(response: HttpServletResponse): ResponseEntity<Any> {
       val cookie = Cookie("jwt", "")
       cookie.maxAge = 0
       response.addCookie(cookie)
       return ResponseEntity.ok("success")
   }

}