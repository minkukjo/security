package me.harry.security.application

import me.harry.security.domain.User
import me.harry.security.infrastructure.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
        val userRepository: UserRepository
) {
    fun create(user: User): User {
        return userRepository.save(user)
    }
}