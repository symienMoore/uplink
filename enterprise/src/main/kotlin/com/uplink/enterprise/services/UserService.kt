package com.uplink.enterprise.services

import com.uplink.enterprise.DTO.RegisterDTO
import com.uplink.enterprise.models.User
import com.uplink.enterprise.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService (private val userRepo: UserRepository) {
    fun createUser(user: User): User {
        return this.userRepo.save(user)
    }

    fun findByUsername(username: String): User? {
        return this.userRepo.findByUsername(username)
    }

    fun findByEmail(email: String): User? {
        return this.userRepo.getUserByEmail(email)
    }
}