package com.uplink.warbird.services

import com.uplink.warbird.models.User
import com.uplink.warbird.repositories.UserRepo
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepo: UserRepo) {
    fun save(user: User): User {
        return this.userRepo.save(user)
    }
}