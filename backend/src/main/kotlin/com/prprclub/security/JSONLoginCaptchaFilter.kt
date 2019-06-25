package com.prprclub.security

import com.prprclub.exception.BadCaptchaException
import org.codehaus.jackson.map.ObjectMapper
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JSONLoginCaptchaFilter: UsernamePasswordAuthenticationFilter() {
    private val objectMapper = ObjectMapper()
    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        val requestBody = objectMapper.readValue(request.reader.readText(), LoginRequest::class.java)

        checkCaptcha(requestBody.captcha, request.remoteAddr)

        val authToken = UsernamePasswordAuthenticationToken(
                requestBody.username,
                requestBody.password
        )

        return authenticationManager.authenticate(authToken)
    }

    data class LoginRequest (
            val username: String,
            val password: String,
            val captcha: String
    )

    private fun checkCaptcha(captcha: String, ipAddr: String? = null) {
        // TODO reCAPTCHA?
        if (captcha != "123456") throw BadCaptchaException()
    }
}