package io.github.lucaswithboots.kotlintodoapi.exception

import io.github.lucaswithboots.kotlintodoapi.dto.ErrorView
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest

@ControllerAdvice
class GlobalExceptionHandler {

    private val logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleResourceNotFoundException(ex: ResourceNotFoundException, request: WebRequest): ResponseEntity<ErrorView> {
        val errorView = ErrorView(
            status = HttpStatus.NOT_FOUND.value(),
            message = ex.message ?: "Erro sem descrição",
            path = request.getDescription(false).substringAfter("uri=").substringBefore(",")
        )

        logger.error("Resource not found: {}", errorView)
        return ResponseEntity(errorView, HttpStatus.NOT_FOUND)
    }
}