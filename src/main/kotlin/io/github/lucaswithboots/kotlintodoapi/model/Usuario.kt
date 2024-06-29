package io.github.lucaswithboots.kotlintodoapi.model

import java.time.LocalDateTime

data class Usuario(
    val id: Long,
    val nome: String,
    val email: String,
    val dataDeCriacao: LocalDateTime = LocalDateTime.now()
)
