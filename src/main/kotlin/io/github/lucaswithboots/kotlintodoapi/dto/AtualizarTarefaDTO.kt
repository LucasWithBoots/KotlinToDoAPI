package io.github.lucaswithboots.kotlintodoapi.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import org.jetbrains.annotations.NotNull

data class AtualizarTarefaDTO(
    @field:NotNull
    @field:Positive
    val id: Long,

    @field:NotBlank
    val titulo: String
)