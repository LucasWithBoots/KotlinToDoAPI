package io.github.lucaswithboots.kotlintodoapi.repository

import io.github.lucaswithboots.kotlintodoapi.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {
}