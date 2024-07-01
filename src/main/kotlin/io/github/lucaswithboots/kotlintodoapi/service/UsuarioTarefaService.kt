package io.github.lucaswithboots.kotlintodoapi.service

import org.springframework.stereotype.Service

@Service
class UsuarioTarefaService(
    private val tarefaService: TarefaService,
    private val usuarioService: UsuarioService
) {
//    fun deletar(id: Long) {
//        tarefaService.deletarPorUsuario(id)
//        usuarioService.deletar(id)
//    }
}