package com.uplink.enterprise.services

import com.uplink.enterprise.models.User
import com.uplink.enterprise.repositories.UserRepository

class UserService (private val userRepo: UserRepository) {
    fun createUser(user: User): User {
        return this.userRepo.save(user)
    }
}