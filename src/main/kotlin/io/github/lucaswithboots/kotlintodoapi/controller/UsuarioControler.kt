package io.github.lucaswithboots.kotlintodoapi.controller

import io.github.lucaswithboots.kotlintodoapi.dto.AtualizarUsuarioDTO
import io.github.lucaswithboots.kotlintodoapi.dto.UsuarioDTO
import io.github.lucaswithboots.kotlintodoapi.model.Usuario
import io.github.lucaswithboots.kotlintodoapi.service.UsuarioService
import io.github.lucaswithboots.kotlintodoapi.service.UsuarioTarefaService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuario")
class UsuarioControler(
    private val service: UsuarioService,
    private val serviceUsuarioTarefaService: UsuarioTarefaService
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
    @Transactional
    fun criar(@RequestBody @Valid usuarioDTO: UsuarioDTO): ResponseEntity<Usuario> {
        val usuario = service.criar(usuarioDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario)
    }

    @PutMapping()
    @Transactional
    fun atualizar(@RequestBody atualizarUsuarioDTO: AtualizarUsuarioDTO): ResponseEntity<Usuario> {
        val usuario = service.atualizar(atualizarUsuarioDTO)
        return ResponseEntity.status(HttpStatus.OK).body(usuario)
    }

//    @DeleteMapping("/{id}")
//    @Transactional
//    fun deletar(@PathVariable id: Long) {
//        // Deletar um usuário deleta todas suas tarefas automaticamente
//        serviceUsuarioTarefaService.deletar(id)
//    }

}