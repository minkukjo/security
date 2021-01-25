package me.harry.security.infrastructure.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration
import org.springframework.security.crypto.keys.KeyManager
import org.springframework.security.crypto.keys.StaticKeyGeneratingKeyManager
import org.springframework.security.oauth2.core.AuthorizationGrantType
import org.springframework.security.oauth2.core.ClientAuthenticationMethod
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository
import java.time.Duration
import java.util.UUID


@EnableWebSecurity
@Configuration(proxyBeanMethods = false)
@Import(OAuth2AuthorizationServerConfiguration::class)
class AuthorizationServerConfiguration {
    @Bean
    fun registeredClientRepository(): RegisteredClientRepository {
        val registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId("test")
                .clientSecret("secret")
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .redirectUri("http://localhost:8080/authorized")
                .tokenSettings {
//                    it.enableRefreshTokens(false) // 이 옵션은 디폴트로 true이며 false를 주면 리프레시 토큰을 주지 않는다.
                    it.accessTokenTimeToLive(Duration.ofHours(1)) // 토큰 만료 시간
                     
                }
                .scope("test")
                .build()
        return InMemoryRegisteredClientRepository(registeredClient)
    }

    @Bean
    fun keyManager(): KeyManager {
        return StaticKeyGeneratingKeyManager()
    }
}