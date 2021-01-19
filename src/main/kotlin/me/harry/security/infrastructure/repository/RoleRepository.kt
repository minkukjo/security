package me.harry.security.infrastructure.repository

import me.harry.security.domain.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository : JpaRepository<Role, Long> {
}