package io.github.lucaswithboots.kotlintodoapi.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class UsuarioDTO(
    @field:NotBlank
    val nome: String,

    @field:NotBlank
    @field:Email
    val email: String
)