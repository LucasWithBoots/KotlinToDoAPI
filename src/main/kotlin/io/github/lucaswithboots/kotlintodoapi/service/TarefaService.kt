package io.github.lucaswithboots.kotlintodoapi.service

import io.github.lucaswithboots.kotlintodoapi.model.Tarefa
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TarefaService(
    private var tarefas: List<Tarefa> = listOf()
) {
    init {
        tarefas = listOf(
            Tarefa(
                id = 1,
                titulo = "Titulo teste",
                descricao = "Descrição teste",
                dataDeCriacao = LocalDateTime.now()
            ),
            Tarefa(
                id = 2,
                titulo = "Titulo teste",
                descricao = "Descrição teste",
                dataDeCriacao = LocalDateTime.now()
            )
        )
    }

    fun listar(): List<Tarefa> {
        return tarefas
    }

    fun listarPorId(id: Long): Tarefa? {
        return tarefas.find { it.id == id }
    }

}