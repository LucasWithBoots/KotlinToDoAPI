package io.github.lucaswithboots.kotlintodoapi.repository

import io.github.lucaswithboots.kotlintodoapi.model.StatusTarefa
import io.github.lucaswithboots.kotlintodoapi.model.Tarefa
import org.springframework.data.jpa.repository.JpaRepository

interface TarefaRepository : JpaRepository<Tarefa, Long> {
    fun findByOrderById(): List<Tarefa>

    fun findByUsuarioId(usuario_id: Long): List<Tarefa>

    fun findByStatusOrderById(status: StatusTarefa): List<Tarefa>
}