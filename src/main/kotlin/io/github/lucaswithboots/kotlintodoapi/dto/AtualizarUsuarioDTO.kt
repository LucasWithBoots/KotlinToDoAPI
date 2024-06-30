package io.github.lucaswithboots.kotlintodoapi.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive
import org.jetbrains.annotations.NotNull

data class AtualizarUsuarioDTO(
    @field:NotNull
    @field:Positive
    val id: Long,

    @field:NotBlank
    val nome: String,

    @field:NotBlank
    val email: String
)