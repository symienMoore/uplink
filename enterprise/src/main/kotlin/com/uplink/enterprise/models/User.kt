package com.uplink.enterprise.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDateTime


@Document
class User {

    @Id
    var id: ObjectId = ObjectId.get()
    @Field
    var name: String = ""
    @Field
    var username: String = ""
    @Field
    var email: String = ""
    @Field
    var password: String = ""
    get() = field
    set(value) {
        var passwordEncoder = BCryptPasswordEncoder()
        field = passwordEncoder.encode(value)
    }

    @Field
    var createdDate: LocalDateTime = LocalDateTime.now()

    @Field
    var modifiedDate: LocalDateTime = LocalDateTime.now()

    fun comparePassword(password: String): Boolean {
       return BCryptPasswordEncoder().matches(password, this.password)
    }

//    @DBRef
//    @Field
//    var messages: List<Message> = TODO()
//
//    @DBRef
//    @Field
//    var groups: Set<Group>
//
//    @DBRef
//    @Field
//    var channels: Set<Channel>
}
