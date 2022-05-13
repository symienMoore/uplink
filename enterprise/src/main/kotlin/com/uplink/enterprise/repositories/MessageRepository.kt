package com.uplink.enterprise.repositories

import com.uplink.enterprise.models.Message
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository : MongoRepository<Message, String> {
//    fun findMessageByIdAndDelete(messageId: String)
}