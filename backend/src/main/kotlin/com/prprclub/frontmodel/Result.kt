package com.prprclub.frontmodel

import com.fasterxml.jackson.annotation.JsonInclude

object ResultCodes {
        const val SUCCESS = 0
        const val GENERAL_ERROR = -1
        const val MALFORMED_REQUEST = -2

        const val BAD_CREDENTIALS = -101
}

data class Result(
        val code: Int = 0,
        val message: String = "OK",
        @JsonInclude(JsonInclude.Include.NON_NULL)
        val data: Any? = null
)