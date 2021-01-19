package me.harry.security.infrastructure.repository

import me.harry.security.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}