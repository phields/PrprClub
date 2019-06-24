package com.prprclub.security

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@PropertySource("security.properties")
class SecurityConfig {
    @Value("\${secret}")
    lateinit var secret: String
    @Value("\${tokenExpireMs}")
    var tokenExpireMs: Long = 0

    @Value("\${google.recaptcha.key.site}")
    lateinit var reCaptchaSite: String
    @Value("\${google.recaptcha.key.secret}")
    lateinit var reCaptchaSecret: String
}