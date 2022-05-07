package com.uplink.enterprise.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDateTime


@Document
class User {

    @Id
    val id: ObjectId = ObjectId.get()
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
        val passwordEncoder = BCryptPasswordEncoder()
        field = passwordEncoder.encode(value)
    }

    @Field
    val createdDate: LocalDateTime = LocalDateTime.now()

    @Field
    val modifiedDate: LocalDateTime = LocalDateTime.now()

}
