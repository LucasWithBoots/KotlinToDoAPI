package io.github.lucaswithboots.kotlintodoapi.service

import io.github.lucaswithboots.kotlintodoapi.dto.AtualizarStatusTarefaDTO
import io.github.lucaswithboots.kotlintodoapi.dto.AtualizarTarefaDTO
import io.github.lucaswithboots.kotlintodoapi.dto.TarefaDTO
import io.github.lucaswithboots.kotlintodoapi.exception.ResourceNotFoundException
import io.github.lucaswithboots.kotlintodoapi.model.StatusTarefa
import io.github.lucaswithboots.kotlintodoapi.model.Tarefa
import org.springframework.stereotype.Service

@Service
class TarefaService(
    private var tarefas: List<Tarefa> = listOf(),
    private val usuarioService: UsuarioService
) {

    fun listar(): List<Tarefa> {

        if (tarefas.isNotEmpty()) {
            return tarefas
        } else {
            throw ResourceNotFoundException("Não há tarefas cadastradas")
        }
    }

    fun listarPorId(id: Long): Tarefa {

        val tarefa = tarefas.find { it.id == id }

        if (tarefa != null) {
            return tarefa
        } else {
            throw ResourceNotFoundException("Não exite tarefa cadastrada com esse ID")
        }
    }

    fun criar(tarefaDTO: TarefaDTO): Tarefa {

        // Não é necessário validação da tarefa, já que o programa não vai adicionar uma tarefa
        // a um usuário que não existe
        val usuario = usuarioService.listarPorId(tarefaDTO.idUsuario)
        val tarefa = Tarefa(
            id = tarefas.size.toLong() + 1,
            titulo = tarefaDTO.titulo,
            descricao = tarefaDTO.descricao,
            usuario = usuario,
            status = StatusTarefa.PENDENTE
        )

        tarefas = tarefas.plus(
            tarefa
        )

        return tarefa
    }

    fun atualizar(atualizarTarefaDTO: AtualizarTarefaDTO): Tarefa {
        val tarefa = listarPorId(atualizarTarefaDTO.id)

        val tarefaAtualizada = Tarefa(
            id = atualizarTarefaDTO.id,
            titulo = atualizarTarefaDTO.titulo,
            descricao = atualizarTarefaDTO.descricao,
            usuario = tarefa.usuario
        )

        tarefas = tarefas.minus(tarefa).plus(tarefaAtualizada)

        return tarefaAtualizada
    }

    fun atualizar(atualizarStatusTarefaDTO: AtualizarStatusTarefaDTO): Tarefa {
        val tarefa = listarPorId(atualizarStatusTarefaDTO.id)

        val tarefaAtualizada = Tarefa(
            id = atualizarStatusTarefaDTO.id,
            titulo = tarefa.titulo,
            descricao = tarefa.descricao,
            usuario = tarefa.usuario,
            status = atualizarStatusTarefaDTO.status
        )

        tarefas = tarefas.minus(tarefa).plus(tarefaAtualizada)

        return tarefaAtualizada
    }

    fun deletar(id: Long) {
        val tarefa = listarPorId(id)

        tarefas = tarefas.minus(tarefa)
    }

    fun deletarPorUsuario(idUsuario: Long) {
        tarefas = tarefas.filter { it.usuario.id != idUsuario }
    }

}