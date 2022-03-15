package com.example.warbird.services

import com.example.warbird.models.User
import com.example.warbird.repositories.UserRepo
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepo: UserRepo) {
    fun save(user: User): User{
        return this.userRepo.save(user)
    }
}