package io.github.lucaswithboots.kotlintodoapi.service

import io.github.lucaswithboots.kotlintodoapi.dto.AtualizarStatusTarefaDTO
import io.github.lucaswithboots.kotlintodoapi.dto.AtualizarTarefaDTO
import io.github.lucaswithboots.kotlintodoapi.dto.TarefaDTO
import io.github.lucaswithboots.kotlintodoapi.model.StatusTarefa
import io.github.lucaswithboots.kotlintodoapi.model.Tarefa
import io.github.lucaswithboots.kotlintodoapi.repository.TarefaRepository
import org.springframework.stereotype.Service

@Service
class TarefaService(
    private var repository: TarefaRepository,
    private val usuarioService: UsuarioService
) {

    fun listar(status: StatusTarefa?): List<Tarefa> {
        return if(status != null){
            repository.findByStatus(status)
        } else {
            repository.findAll()
        }
    }

    fun listarPorId(id: Long): Tarefa {
        return repository.getReferenceById(id)
    }

    fun criar(tarefaDTO: TarefaDTO): Tarefa {
        val usuario = usuarioService.listarPorId(tarefaDTO.idUsuario)

        val tarefa = Tarefa(
            titulo = tarefaDTO.titulo,
            usuario = usuario,
            status = StatusTarefa.PENDENTE
        )

        repository.save(tarefa)

        return tarefa
    }

    fun atualizar(atualizarTarefaDTO: AtualizarTarefaDTO): Tarefa {
        val tarefa = listarPorId(atualizarTarefaDTO.id)

        tarefa.titulo = atualizarTarefaDTO.titulo

        return tarefa
    }

    fun atualizar(atualizarStatusTarefaDTO: AtualizarStatusTarefaDTO): Tarefa {
        val tarefa = listarPorId(atualizarStatusTarefaDTO.id)

        tarefa.status = atualizarStatusTarefaDTO.status

        return tarefa
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}