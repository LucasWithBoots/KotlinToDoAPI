package io.github.lucaswithboots.kotlintodoapi.controller

import io.github.lucaswithboots.kotlintodoapi.dto.AtualizarStatusTarefaDTO
import io.github.lucaswithboots.kotlintodoapi.dto.AtualizarTarefaDTO
import io.github.lucaswithboots.kotlintodoapi.dto.TarefaDTO
import io.github.lucaswithboots.kotlintodoapi.model.Tarefa
import io.github.lucaswithboots.kotlintodoapi.service.TarefaService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tarefa")
class TarefaController(
    private val service: TarefaService
) {

    @GetMapping
    fun listar(): List<Tarefa> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun listarPorId(@PathVariable id: Long): Tarefa? {
        return service.listarPorId(id)
    }

    @PostMapping
    fun criar(@RequestBody @Valid tarefaDTO: TarefaDTO) {
        service.criar(tarefaDTO)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid atualizarTarefaDTO: AtualizarTarefaDTO) {
        service.atualizar(atualizarTarefaDTO)
    }

    @PutMapping("/status")
    fun atualizar(@RequestBody @Valid atualizarStatusTarefaDTO: AtualizarStatusTarefaDTO) {
        service.atualizar(atualizarStatusTarefaDTO)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}