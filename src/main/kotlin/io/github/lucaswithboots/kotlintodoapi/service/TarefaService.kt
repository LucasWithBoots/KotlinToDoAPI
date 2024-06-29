package io.github.lucaswithboots.kotlintodoapi.service

import io.github.lucaswithboots.kotlintodoapi.dto.TarefaDTO
import io.github.lucaswithboots.kotlintodoapi.model.Tarefa
import org.springframework.stereotype.Service

@Service
class TarefaService(
    private var tarefas: List<Tarefa> = listOf(),
    private val usuarioService: UsuarioService
) {

    fun listar(): List<Tarefa> {
        return tarefas
    }

    fun listarPorId(id: Long): Tarefa? {
        return tarefas.find { it.id == id }
    }

    fun criarTarefa(tarefaDTO: TarefaDTO) {

        val usuario = usuarioService.listarPorId(tarefaDTO.idUsuario)

        tarefas = tarefas.plus(
            Tarefa(
                id = tarefas.size.toLong() + 1,
                titulo = tarefaDTO.titulo,
                descricao = tarefaDTO.descricao,
                usuario = usuario
            )
        )
    }

}