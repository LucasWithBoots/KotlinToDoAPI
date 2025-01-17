package io.github.lucaswithboots.kotlintodoapi.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Tarefa(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var titulo: String,
    @Column(name = "datadecriacao")
    val dataDeCriacao: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val usuario: Usuario,
    @Enumerated(EnumType.STRING)
    var status: StatusTarefa = StatusTarefa.PENDENTE
)
