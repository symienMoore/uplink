package com.example.warbird.repositories

import com.example.warbird.models.User
import org.springframework.data.repository.CrudRepository

interface UserRepo: CrudRepository<User, Long> {
}