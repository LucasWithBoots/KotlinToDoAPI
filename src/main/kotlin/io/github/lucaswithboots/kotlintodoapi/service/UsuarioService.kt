package io.github.lucaswithboots.kotlintodoapi.service

import io.github.lucaswithboots.kotlintodoapi.dto.AtualizarUsuarioDTO
import io.github.lucaswithboots.kotlintodoapi.dto.UsuarioDTO
import io.github.lucaswithboots.kotlintodoapi.model.Usuario
import io.github.lucaswithboots.kotlintodoapi.repository.TarefaRepository
import io.github.lucaswithboots.kotlintodoapi.repository.UsuarioRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UsuarioService(
    private var repository: UsuarioRepository,
    private val tarefaRepository: TarefaRepository
) {
    fun listar(): List<Usuario> {
        return repository.findAll()
    }

    fun listarPorId(id: Long): Usuario {
        return repository.getReferenceById(id)
    }

    fun criar(usuarioDTO: UsuarioDTO): Usuario {
        val usuario = Usuario(
            nome = usuarioDTO.nome,
            email = usuarioDTO.email
        )

        repository.save(usuario)

        return usuario
    }

    fun atualizar(atualizarUsuarioDTO: AtualizarUsuarioDTO): Usuario {
        val usuario = listarPorId(atualizarUsuarioDTO.id)

        usuario.nome = atualizarUsuarioDTO.nome
        usuario.email = atualizarUsuarioDTO.email

        return usuario
    }

    @Transactional
    fun deletar(id: Long) {
        // Deletar todas as tarefas do usuário
        val tarefas = tarefaRepository.findByUsuarioId(id)
        tarefaRepository.deleteAll(tarefas)

        // Deletar o usuário
        repository.deleteById(id)
    }

}