package com.prprclub.utils

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

fun HttpServletRequest.readText() = reader.readText()
fun HttpServletResponse.writeAndFlush(str: String) {
    characterEncoding = "UTF-8"
    writer.apply {
        write(str)
        flush()
    }
}