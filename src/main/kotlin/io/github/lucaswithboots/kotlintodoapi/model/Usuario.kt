package io.github.lucaswithboots.kotlintodoapi.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var nome: String,
    var email: String,
    @Column(name = "datadecriacao")
    val dataDeCriacao: LocalDateTime = LocalDateTime.now()
)
