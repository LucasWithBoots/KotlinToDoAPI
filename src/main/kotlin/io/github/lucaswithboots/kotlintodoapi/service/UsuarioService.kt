package io.github.lucaswithboots.kotlintodoapi.service

import io.github.lucaswithboots.kotlintodoapi.dto.AtualizarUsuarioDTO
import io.github.lucaswithboots.kotlintodoapi.dto.UsuarioDTO
import io.github.lucaswithboots.kotlintodoapi.exception.ResourceNotFoundException
import io.github.lucaswithboots.kotlintodoapi.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private var usuarios: List<Usuario> = listOf(),
    //private var tarefaService: TarefaService
) {
    fun listar(): List<Usuario> {

        if (usuarios.isNotEmpty()) {
            return usuarios
        } else {
            throw ResourceNotFoundException("Não há usuários cadastrados")
        }
    }

    fun listarPorId(id: Long): Usuario {
        val usuario = usuarios.find { it.id == id }

        if (usuario != null) {
            return usuario
        } else {
            throw ResourceNotFoundException("Não exite usuário cadastrado com esse ID")
        }
    }

    fun criar(usuarioDTO: UsuarioDTO): Usuario {
        val usuario = Usuario(
            id = usuarios.count().toLong() + 1,
            nome = usuarioDTO.nome,
            email = usuarioDTO.email
        )

        usuarios = usuarios.plus(
            usuario
        )

        return usuario
    }

    fun atualizar(atualizarUsuarioDTO: AtualizarUsuarioDTO): Usuario {
        val usuario = listarPorId(atualizarUsuarioDTO.id)

        val usuarioAtualizado = Usuario(
            id = atualizarUsuarioDTO.id,
            nome = atualizarUsuarioDTO.nome,
            email = atualizarUsuarioDTO.email
        )

        usuarios = usuarios.minus(usuario).plus(usuarioAtualizado)

        return usuarioAtualizado
    }

    fun deletar(id: Long) {
        val usuario = listarPorId(id)

//        tarefaService.deletarPorUsuario(id)

        usuarios = usuarios.minus(usuario)
    }


}