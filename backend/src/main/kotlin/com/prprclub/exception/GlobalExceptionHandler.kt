package com.prprclub.exception

import com.prprclub.frontmodel.Result
import com.prprclub.frontmodel.ResultCodes.GENERAL_ERROR
import com.prprclub.frontmodel.ResultCodes.MALFORMED_REQUEST
import org.codehaus.jackson.JsonProcessingException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(value = [Exception::class])
    fun defaultErrorHandler(req: HttpServletRequest, e: Exception): ResponseEntity<Result> {
        when (e) {
            is WrappedException -> {
                return ResponseEntity
                        .status(e.httpStatus)
                        .body(Result(
                                code = e.code,
                                message = e.message ?: "error"
                        ))
            }
            is JsonProcessingException -> {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(Result(
                                code = MALFORMED_REQUEST
                        ))
            }
            else -> {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(Result(
                                code = GENERAL_ERROR,
                                message = e.message ?: "error"
                        ))
            }
        }
    }
}