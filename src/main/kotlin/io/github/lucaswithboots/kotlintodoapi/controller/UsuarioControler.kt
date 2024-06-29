package io.github.lucaswithboots.kotlintodoapi.controller

import io.github.lucaswithboots.kotlintodoapi.dto.UsuarioDTO
import io.github.lucaswithboots.kotlintodoapi.model.Usuario
import io.github.lucaswithboots.kotlintodoapi.service.UsuarioService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuario")
class UsuarioControler(
    private val service: UsuarioService
) {

    @GetMapping
    fun listar(): List<Usuario> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun listarPorId(@PathVariable id: Long): Usuario? {
        return service.listarPorId(id)
    }

    @PostMapping
    fun criar(@RequestBody usuarioDTO: UsuarioDTO) {
        service.criar(usuarioDTO)
    }

}