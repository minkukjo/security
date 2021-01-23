package me.harry.security.infrastructure.config

import me.harry.security.domain.Role
import me.harry.security.domain.User
import me.harry.security.infrastructure.repository.UserRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.security.web.DefaultRedirectStrategy
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

//@Component("oauth2authSuccessHandler")
//class OAuth2AuthenticationSuccessHandler(
//        val userRepository: UserRepository
//) : AuthenticationSuccessHandler {
//
//    val redirectStrategy = DefaultRedirectStrategy()
//
//    override fun onAuthenticationSuccess(request: HttpServletRequest?, response: HttpServletResponse?, authentication: Authentication?) {
//
//        val oAuth2Token = authentication as OAuth2AuthenticationToken
//        userRepository.findByName(authentication.name) ?: run {
//            val name = oAuth2Token.principal.attributes["name"].toString()
//            val email = oAuth2Token.principal.attributes["email"].toString()
//            val user = User(name = name, email = email, password = passwordEncoder().encode("secret"))
//            val role = Role(role = "USER", user = user)
//            user.role.add(role)
//            userRepository.save(user)
//        }
//
//        this.redirectStrategy.sendRedirect(request, response, "/hello")
//
//    }
//}