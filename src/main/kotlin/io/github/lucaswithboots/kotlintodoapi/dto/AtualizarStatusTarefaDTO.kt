package io.github.lucaswithboots.kotlintodoapi.dto

import io.github.lucaswithboots.kotlintodoapi.model.StatusTarefa
import jakarta.validation.constraints.Positive
import org.jetbrains.annotations.NotNull

data class AtualizarStatusTarefaDTO(
    @field:NotNull
    @field:Positive
    val id: Long,

    @field:NotNull
    val status: StatusTarefa
)