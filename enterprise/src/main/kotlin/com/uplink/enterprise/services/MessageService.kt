package com.uplink.enterprise.services

import com.uplink.enterprise.models.Message
import com.uplink.enterprise.repositories.MessageRepository
import com.uplink.enterprise.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class MessageService(private val messageRepo: MessageRepository) {
    fun createMessage(message: Message): Message {
       return this.messageRepo.save(message)
    }
}