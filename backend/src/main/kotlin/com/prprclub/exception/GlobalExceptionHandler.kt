package com.prprclub.exception

import com.prprclub.frontmodel.Result
import com.prprclub.frontmodel.ResultCodes
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
            else -> {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(Result(
                                code = ResultCodes.GENERAL_ERROR,
                                message = e.message ?: "error"
                        ))
            }
        }
    }
}