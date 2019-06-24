package com.prprclub.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.prprclub.frontmodel.Result
import com.prprclub.frontmodel.ResultCodes
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import java.time.Instant
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class AuthenticationResultHandler: AuthenticationFailureHandler, AuthenticationSuccessHandler {
    @Autowired
    private lateinit var securityConfig: SecurityConfig

    override fun onAuthenticationFailure(
            request: HttpServletRequest,
            response: HttpServletResponse,
            exception: AuthenticationException) {
        response.status = HttpStatus.UNAUTHORIZED.value()
        response.characterEncoding = "UTF-8"

        val resp = ObjectMapper().writeValueAsString(Result(
                code = ResultCodes.BAD_CREDENTIALS,
                message = exception.message ?: "error"
        ))

        response.writer.print(resp)
        response.writer.close()
    }

    override fun onAuthenticationSuccess(
            request: HttpServletRequest,
            response: HttpServletResponse,
            authentication: Authentication) {
        val token = Jwts
                .builder()
                .setSubject(authentication.name)
                .setExpiration(Date.from(Instant.now().plusMillis(securityConfig.tokenExpireMs)))
                .setIssuedAt(Date())
                .signWith(SignatureAlgorithm.HS512, securityConfig.secret)
                .compact()

        val resp = ObjectMapper().writeValueAsString(Result(
                code = ResultCodes.SUCCESS,
                data = LoginSuccessResult(token)
        ))

        response.characterEncoding = "UTF-8"
        response.writer.apply {
            print(resp)
            flush()
            close()
        }
    }
}

internal data class LoginSuccessResult(
        val token: String
)