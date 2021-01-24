package me.harry.security.infrastructure.model

import javassist.NotFoundException
import me.harry.security.domain.User
import me.harry.security.infrastructure.repository.RoleRepository
import me.harry.security.infrastructure.repository.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class SecurityUserDetailService(
        val userRepository: UserRepository,
        val roleRepository: RoleRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val name = username ?: throw NotFoundException("user name not found")
        val user = userRepository.findByName(name) ?: throw NotFoundException("user not found by name in db")

        return SecurityUser(username = user.name, password = user.password, authorities = getRole(user),
                isAccountNonExpired = true, isAccountNonLocked = true, isCredentialsNonExpired = true, isEnabled = user.enabled)
    }

    fun getRole(user: User): MutableCollection<GrantedAuthority> {
        val roles = roleRepository.findByUser(user)
        val authorities = mutableListOf<GrantedAuthority>()
        roles.forEach {
            authorities.add(SimpleGrantedAuthority(it.role))
        }
        return authorities
    }
}