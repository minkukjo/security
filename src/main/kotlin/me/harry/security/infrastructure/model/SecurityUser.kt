package me.harry.security.infrastructure.model

//import org.springframework.security.core.GrantedAuthority
//import org.springframework.security.core.userdetails.UserDetails

//
//class SecurityUser(
//        private val username: String,
//        private val password: String,
//        private val isEnabled: Boolean,
//        private val isAccountNonExpired: Boolean,
//        private val isAccountNonLocked: Boolean,
//        private val isCredentialsNonExpired: Boolean,
//        private val authorities: MutableCollection<out GrantedAuthority>
//
//) : UserDetails {
//    override fun getUsername(): String {
//        return this.username
//    }
//
//    override fun isAccountNonExpired(): Boolean {
//        return this.isAccountNonExpired
//    }
//
//    override fun isAccountNonLocked(): Boolean {
//        return this.isAccountNonLocked
//    }
//
//    override fun isCredentialsNonExpired(): Boolean {
//        return this.isCredentialsNonExpired
//    }
//
//    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
//        return this.authorities
//    }
//
//    override fun getPassword(): String {
//        return this.password
//    }
//
//    override fun isEnabled(): Boolean {
//        return this.isEnabled
//    }
//}