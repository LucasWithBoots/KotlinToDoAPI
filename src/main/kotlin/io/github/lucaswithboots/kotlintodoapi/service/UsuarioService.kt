package io.github.lucaswithboots.kotlintodoapi.service

import io.github.lucaswithboots.kotlintodoapi.dto.AtualizarUsuarioDTO
import io.github.lucaswithboots.kotlintodoapi.dto.UsuarioDTO
import io.github.lucaswithboots.kotlintodoapi.exception.ResourceNotFoundException
import io.github.lucaswithboots.kotlintodoapi.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private var usuarios: List<Usuario> = listOf()
) {
    fun listar(): List<Usuario> {

        if (usuarios.isNotEmpty()) {
            return usuarios
        } else {
            throw ResourceNotFoundException("Não há usuários cadastrados")
        }
    }

    fun listarPorId(id: Long): Usuario? {
        val usuario = usuarios.find { it.id == id }

        if (usuario != null) {
            return usuario
        } else {
            throw ResourceNotFoundException("Usuário não cadastrado")
        }
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

    fun atualizar(atualizarUsuarioDTO: AtualizarUsuarioDTO) {
        val usuario = listarPorId(atualizarUsuarioDTO.id)

        if (usuario != null) {
            val usuarioAtualizado = Usuario(
                id = atualizarUsuarioDTO.id,
                nome = atualizarUsuarioDTO.nome,
                email = atualizarUsuarioDTO.email
            )

            usuarios = usuarios.minus(usuario).plus(usuarioAtualizado)
        } else {
            throw ResourceNotFoundException("Usuário não cadastrado")
        }
    }

    fun deletar(id: Long) {
        val usuario = listarPorId(id)

        if (usuario != null) {
            usuarios = usuarios.minus(usuario)
        }
    }


}