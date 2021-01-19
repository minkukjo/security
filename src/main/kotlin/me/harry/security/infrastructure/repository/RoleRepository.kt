package me.harry.security.infrastructure.repository

import me.harry.security.domain.Role
import me.harry.security.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Long> {
    fun findByUser(user: User): List<Role>
}