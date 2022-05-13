package com.uplink.enterprise.repositories

import com.uplink.enterprise.models.Comment
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository : MongoRepository<Comment, String> {
    fun getCommentById(id: String)
//    fun getCommentByIdAndDelete(id: String)

}