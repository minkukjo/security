package me.harry.security.infrastructure.config

import me.harry.security.infrastructure.model.SecurityUserDetailService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.DelegatingPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.AuthenticationSuccessHandler

@Configuration
@Order(2)
class WebSecurityConfiguration(
        val securityUserDetailService: SecurityUserDetailService,
        @Qualifier(value = "oauth2authSuccessHandler")
        val oauth2authSuccessHandler: AuthenticationSuccessHandler
) : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http?.run {
            this.authorizeRequests()
                    .antMatchers("/login").permitAll() // 이 페이지에 한해서는 인증 없이 통과
                    .anyRequest().authenticated() // 그 외 다른 API는 인증 요구
                    .and()
                    .formLogin().loginPage("/login").defaultSuccessUrl("/hello", true) // 로그인은 폼 로그인 방식으로 진행, 로그인이 성공하면 /hello로 이동
                    .and().rememberMe().key("security_key")
                    .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").deleteCookies("remeber-me")
                    .and().oauth2Login().loginPage("/login").successHandler(oauth2authSuccessHandler)
        }
    }

    override fun configure(web: WebSecurity?) {
        web?.run {
            this.ignoring().antMatchers("/css/**", "/webjars/**")
        }
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.run {
            this.userDetailsService(securityUserDetailService)
                    .passwordEncoder(passwordEncoder())
        }
    }
}

fun passwordEncoder(): PasswordEncoder {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder() as DelegatingPasswordEncoder
}