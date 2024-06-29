package io.github.lucaswithboots.kotlintodoapi.service

import io.github.lucaswithboots.kotlintodoapi.dto.AtualizarStatusTarefaDTO
import io.github.lucaswithboots.kotlintodoapi.dto.AtualizarTarefaDTO
import io.github.lucaswithboots.kotlintodoapi.dto.TarefaDTO
import io.github.lucaswithboots.kotlintodoapi.model.StatusTarefa
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

    fun criar(tarefaDTO: TarefaDTO) {

        val usuario = usuarioService.listarPorId(tarefaDTO.idUsuario)

        tarefas = tarefas.plus(
            Tarefa(
                id = tarefas.size.toLong() + 1,
                titulo = tarefaDTO.titulo,
                descricao = tarefaDTO.descricao,
                usuario = usuario,
                status = StatusTarefa.PENDENTE
            )
        )
    }

    fun atualizar(atualizarTarefaDTO: AtualizarTarefaDTO) {
        val tarefa = tarefas.find { it.id == atualizarTarefaDTO.id }

        val tarefaAtualizada = Tarefa(
            id = atualizarTarefaDTO.id,
            titulo = atualizarTarefaDTO.titulo,
            descricao = atualizarTarefaDTO.descricao,
            usuario = tarefa?.usuario
        )

        if (tarefa != null) {
            tarefas = tarefas.minus(tarefa).plus(tarefaAtualizada)
        }
    }

    fun atualizar(atualizarStatusTarefaDTO: AtualizarStatusTarefaDTO) {
        val tarefa = tarefas.find { it.id == atualizarStatusTarefaDTO.id }

        if (tarefa != null) {
            val tarefaAtualizada = Tarefa(
                id = atualizarStatusTarefaDTO.id,
                titulo = tarefa.titulo,
                descricao = tarefa.descricao,
                usuario = tarefa.usuario,
                status = atualizarStatusTarefaDTO.status
            )

            tarefas = tarefas.minus(tarefa).plus(tarefaAtualizada)
        }
    }

    fun deletar(id: Long) {
        val tarefa = tarefas.find { it.id == id }

        if (tarefa != null) {
            tarefas = tarefas.minus(tarefa)
        }
    }

}