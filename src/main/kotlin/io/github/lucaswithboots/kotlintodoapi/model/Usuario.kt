package io.github.lucaswithboots.kotlintodoapi.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var nome: String,
    var email: String,
    val dataDeCriacao: LocalDateTime = LocalDateTime.now()
)
