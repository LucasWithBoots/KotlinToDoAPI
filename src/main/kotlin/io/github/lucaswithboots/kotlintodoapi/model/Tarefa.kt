package io.github.lucaswithboots.kotlintodoapi.model

import java.time.LocalDateTime

data class Tarefa(
    val id: Long,
    val titulo: String,
    val descricao: String,
    val dataDeCriacao: LocalDateTime = LocalDateTime.now()
)
