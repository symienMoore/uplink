package com.uplink.enterprise.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class User (
    @Id
    val id: ObjectId = ObjectId.get(),
    val name: String = "",
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val modifiedDate: LocalDateTime = LocalDateTime.now()
){

//    val id: String = ""
//    val name: String = ""
//    val username: String = ""
//    val email: String = ""
//    val password: String = ""



}