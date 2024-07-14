package io.github.lucaswithboots.kotlintodoapi.repository

import io.github.lucaswithboots.kotlintodoapi.model.StatusTarefa
import io.github.lucaswithboots.kotlintodoapi.model.Tarefa
import org.springframework.data.jpa.repository.JpaRepository

interface TarefaRepository : JpaRepository<Tarefa, Long> {
    fun findByUsuarioId(usuario_id: Long): List<Tarefa>

    fun findByStatus(status: StatusTarefa): List<Tarefa>
}