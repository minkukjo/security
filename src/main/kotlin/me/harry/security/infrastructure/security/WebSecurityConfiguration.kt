package me.harry.security.infrastructure.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class WebSecurityConfiguration : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http?.run {
            this.authorizeRequests()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .httpBasic()
        }
    }
}