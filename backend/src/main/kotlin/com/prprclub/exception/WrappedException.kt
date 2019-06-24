package com.prprclub.exception

import org.springframework.http.HttpStatus

class WrappedException(
        message: String,
        val httpStatus: HttpStatus,
        val code: Int
): Exception(message)