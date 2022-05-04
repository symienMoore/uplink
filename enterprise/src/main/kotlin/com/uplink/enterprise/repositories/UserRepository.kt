package com.uplink.enterprise.repositories

import com.uplink.enterprise.models.User
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String> {
    fun findOneById(id: ObjectId): User
    override fun delete(entity: User)

}