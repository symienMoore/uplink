package com.example.warbird.models

import javax.annotation.processing.Generated
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val first_name: String,
    val last_name: String,
    val password: String,
    val username: String,
    val email: String,
    val profile_picture: String
) {
}