package io.github.lucaswithboots.kotlintodoapi.dto

data class AtualizarTarefaDTO(
    val id: Long,
    val titulo: String,
    val descricao: String,
)