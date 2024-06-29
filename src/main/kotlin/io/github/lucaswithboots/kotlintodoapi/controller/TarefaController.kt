package io.github.lucaswithboots.kotlintodoapi.controller

import io.github.lucaswithboots.kotlintodoapi.dto.TarefaDTO
import io.github.lucaswithboots.kotlintodoapi.model.Tarefa
import io.github.lucaswithboots.kotlintodoapi.service.TarefaService
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
    fun criar(@RequestBody tarefaDTO: TarefaDTO) {
        service.criar(tarefaDTO)
    }

}