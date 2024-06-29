package io.github.lucaswithboots.kotlintodoapi.service

import io.github.lucaswithboots.kotlintodoapi.dto.UsuarioDTO
import io.github.lucaswithboots.kotlintodoapi.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private var usuarios: List<Usuario> = listOf()
) {
    fun listar(): List<Usuario> {
        return usuarios
    }

    fun listarPorId(id: Long): Usuario? {
        return usuarios.find { it.id == id }
    }

    fun criar(usuarioDTO: UsuarioDTO) {
        usuarios = usuarios.plus(
            Usuario(
                id = usuarios.count().toLong() + 1,
                nome = usuarioDTO.nome,
                email = usuarioDTO.email
            )
        )
    }

    fun deletar(id: Long) {
        val usuario = usuarios.find { it.id == id }

        if (usuario != null) {
            usuarios = usuarios.minus(usuario)
        }
    }

}