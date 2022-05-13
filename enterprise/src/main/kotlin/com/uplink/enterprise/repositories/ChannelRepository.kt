package com.uplink.enterprise.repositories

import com.uplink.enterprise.models.Channel
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ChannelRepository : MongoRepository<Channel, String> {

}