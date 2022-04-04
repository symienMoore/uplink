package com.uplink.warbird.repositories

import com.uplink.warbird.models.User
import org.springframework.data.repository.CrudRepository

interface UserRepo: CrudRepository<User, Long> {
}