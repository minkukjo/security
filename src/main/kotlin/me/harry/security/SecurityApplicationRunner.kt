package me.harry.security

import me.harry.security.application.UserService
import me.harry.security.domain.Role
import me.harry.security.domain.User
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

//@Component
//class SecurityApplicationRunner(
//        val userService: UserService
//) : ApplicationRunner {
//    override fun run(args: ApplicationArguments?) {
//        val dummyUser1 = User(name = "harry", password = "{noop}secret", email = "harry.code@kakao.com", enabled = true)
//        val role1 = Role(user = dummyUser1, role = "ADMIN")
//        dummyUser1.role.add(role1)
//        userService.create(dummyUser1)
//        val dummyUser2 = User(name = "admin", password = "{noop}secret", email = "admin@kakao.com", enabled = true)
//        val role2 = Role(user = dummyUser2, role = "ADMIN")
//        dummyUser2.role.add(role2)
//        userService.create(dummyUser2)
//        val dummyUser3 = User(name = "user", password = "{noop}secret", email = "user@kakao.com", enabled = true)
//        val role3 = Role(user = dummyUser3, role = "USER")
//        dummyUser3.role.add(role3)
//        userService.create(dummyUser3)
//    }
//}