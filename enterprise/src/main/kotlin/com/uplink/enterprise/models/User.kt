package com.uplink.enterprise.models

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User (
    @Id
    val id: ObjectId = ObjectId.get(),
    val name: String = "",
    val username: String = "",
    val email: String = "",
    val password: String = ""
){

//    val id: String = ""
//    val name: String = ""
//    val username: String = ""
//    val email: String = ""
//    val password: String = ""



}