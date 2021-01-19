package me.harry.security.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "users")
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @Column(nullable = false, length = 50)
        val name: String = "",

        @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
        val role: MutableList<Role> = mutableListOf(),

        @Column(nullable = false, length = 200)
        val password: String,

        @Column(nullable = false, length = 200)
        val email: String,

        val enabled: Boolean = false,

        @CreatedDate
        val createdAt: LocalDateTime = LocalDateTime.now(),

        @LastModifiedDate
        val updatedAt: LocalDateTime = LocalDateTime.now(),
)