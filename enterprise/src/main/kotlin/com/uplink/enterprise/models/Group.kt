package com.uplink.enterprise.models
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime

@Document
class Group {

    @Id
    var id: ObjectId = ObjectId.get()
    @Field
    var title: String = ""
    @Field
    var createdDate: LocalDateTime = LocalDateTime.now()
    @Field
    val users: MutableList<User> = mutableListOf()
    @DBRef
    @Field
    val user: User = User()
}