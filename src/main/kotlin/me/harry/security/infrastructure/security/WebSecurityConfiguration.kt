package me.harry.security.infrastructure.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.DelegatingPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import javax.sql.DataSource

@Configuration
@Order(2)
class WebSecurityConfiguration(
        val dataSource: DataSource
) : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http?.run {
            this.authorizeRequests()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .httpBasic()
        }
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder() as DelegatingPasswordEncoder
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.run {
            this.jdbcAuthentication()
                    .dataSource(dataSource)
                    .passwordEncoder(passwordEncoder())
        }
    }
}