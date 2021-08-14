package com.study.springboot.feign.domain.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.*

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(InternalRequestException::class)
    fun handleInternalRequestException(exception: InternalRequestException): ResponseEntity<ErrorResponse> {
        return ResponseEntity<ErrorResponse>(ErrorResponse(exception.message, exception.code, Date()), HttpStatus.valueOf(exception.status))
    }
}