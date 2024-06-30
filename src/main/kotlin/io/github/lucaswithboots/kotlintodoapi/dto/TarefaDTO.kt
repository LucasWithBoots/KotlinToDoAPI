package io.github.lucaswithboots.kotlintodoapi.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import org.jetbrains.annotations.NotNull


data class TarefaDTO(
    @field:NotNull
    @field:Positive
    val idUsuario: Long,

    @field:NotBlank
    val titulo: String,

    @field:NotBlank
    val descricao: String
)