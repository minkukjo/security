//package me.harry.security.infrastructure.config
//
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.core.annotation.Order
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.crypto.password.PasswordEncoder
//import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint
//import org.springframework.security.web.authentication.www.DigestAuthenticationFilter
//
//@Configuration
//@Order(1)
//class AdminSecurityConfiguration(
//) : WebSecurityConfigurerAdapter() {
//
//    @Bean
//    override fun userDetailsServiceBean(): UserDetailsService {
//        return super.userDetailsServiceBean()
//    }
//
//    override fun configure(auth: AuthenticationManagerBuilder?) {
//        auth?.run {
//            this.inMemoryAuthentication()
//                    .withUser("digestharry")
//                    .password(passwordEncoder().encode("digestsecret"))
//                    .roles("USER")
//                    .and()
//                    .withUser("admin")
//                    .password(passwordEncoder().encode("adminsecret"))
//                    .roles("ADMIN")
//        }
//    }
//
//    override fun configure(http: HttpSecurity?) {
//        http?.run {
//            this
//                    .antMatcher("/admin/**") // 이 필터는 해당 URL 패턴에 일치하면
//                    .addFilter(getDigestAuthFilter()).exceptionHandling() // 얘를 추가하고 예외를 핸들링 할것이며
//                    .authenticationEntryPoint(getDigestEntryPoint()) // 얘를 추가한다는 뜻
//                    .and() // 그리고
//                    .authorizeRequests() // 인증이 필요한데
//                    .antMatchers("/admin/**") // 이 /admin 아래에 들어오는 모든 요청들에 대해서 인증을 요구할 것이며
//                    .hasRole("ADMIN") // 어드민 권한이 있을 때만 접근 가능하게 할거라는 뜻
//        }
//    }
//
//    private fun getDigestAuthFilter(): DigestAuthenticationFilter {
//        val digestFilter = DigestAuthenticationFilter()
//        digestFilter.userDetailsService = userDetailsServiceBean()
//
//        digestFilter.setAuthenticationEntryPoint(getDigestEntryPoint())
//        return digestFilter
//    }
//
//    private fun getDigestEntryPoint(): DigestAuthenticationEntryPoint {
//        val digestEntryPoint = DigestAuthenticationEntryPoint()
//        digestEntryPoint.key = "somedigestkey" // number once를 생성하기 위한
//        digestEntryPoint.realmName = "admin-digest-realm" // 유니크 Identifier
//        return digestEntryPoint
//    }
//}