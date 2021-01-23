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
                .redirectUri("http://localhost:8080/authorized")
                .scope("test")
                .build()
        return InMemoryRegisteredClientRepository(registeredClient)
    }

    @Bean
    fun keyManager(): KeyManager {
        return StaticKeyGeneratingKeyManager()
    }
}