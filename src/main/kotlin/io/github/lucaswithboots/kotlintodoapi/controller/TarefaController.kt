package io.github.lucaswithboots.kotlintodoapi.controller

import io.github.lucaswithboots.kotlintodoapi.dto.AtualizarStatusTarefaDTO
import io.github.lucaswithboots.kotlintodoapi.dto.AtualizarTarefaDTO
import io.github.lucaswithboots.kotlintodoapi.dto.TarefaDTO
import io.github.lucaswithboots.kotlintodoapi.model.StatusTarefa
import io.github.lucaswithboots.kotlintodoapi.model.Tarefa
import io.github.lucaswithboots.kotlintodoapi.service.TarefaService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tarefa")
class TarefaController(
    private val service: TarefaService
) {

    @GetMapping
    fun listar(@RequestParam(required=false) status: StatusTarefa?): List<Tarefa> {
        return service.listar(status)
    }

    @GetMapping("/{id}")
    fun listarPorId(@PathVariable id: Long): Tarefa? {
        return service.listarPorId(id)
    }

    @PostMapping
    @Transactional
    fun criar(
        @RequestBody @Valid tarefaDTO: TarefaDTO
    ): ResponseEntity<Tarefa> {
        val tarefa = service.criar(tarefaDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefa)
    }

    @PutMapping
    @Transactional
    fun atualizar(@RequestBody @Valid atualizarTarefaDTO: AtualizarTarefaDTO): ResponseEntity<Tarefa> {
        val tarefa = service.atualizar(atualizarTarefaDTO)
        return ResponseEntity.status(HttpStatus.OK).body(tarefa)
    }

    @PutMapping("/status")
    @Transactional
    fun atualizar(@RequestBody @Valid atualizarStatusTarefaDTO: AtualizarStatusTarefaDTO): ResponseEntity<Tarefa> {
        val tarefa = service.atualizar(atualizarStatusTarefaDTO)
        return ResponseEntity.status(HttpStatus.OK).body(tarefa)
    }

    @DeleteMapping("/{id}")
    @Transactional
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}