package io.github.lucaswithboots.kotlintodoapi.dto

import io.github.lucaswithboots.kotlintodoapi.model.StatusTarefa

data class AtualizarStatusTarefaDTO(
    val id: Long,
    val status: StatusTarefa
)