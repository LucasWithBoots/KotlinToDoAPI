package io.github.lucaswithboots.kotlintodoapi.controller

import io.github.lucaswithboots.kotlintodoapi.model.Tarefa
import io.github.lucaswithboots.kotlintodoapi.service.TarefaService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

}