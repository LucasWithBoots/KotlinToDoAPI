package io.github.lucaswithboots.kotlintodoapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinToDoApiApplication

fun main(args: Array<String>) {
    runApplication<KotlinToDoApiApplication>(*args)
}
