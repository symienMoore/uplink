package com.uplink.enterprise.services

import com.uplink.enterprise.models.Message
import com.uplink.enterprise.models.User
import com.uplink.enterprise.repositories.UserRepository
import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.Update
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

    fun getById(id: String): User? {
        return this.userRepo.getUserById(id)
    }

//    fun updateUserWithMessage(user: User, message: ObjectId): User? {
//        var myUser = this.getById(user.id.toString())
//        myUser?.messages?.add(message)
//        return user
//    }
}