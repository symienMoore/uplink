package com.uplink.warbird.models

import javax.annotation.processing.Generated
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,

    @Column
    val first_name: String,

    @Column
    val last_name: String,

    @Column
    val password: String,

    @Column
    val username: String,

    @Column
    val email: String,

    @Column
    val profile_picture: String
) {
}