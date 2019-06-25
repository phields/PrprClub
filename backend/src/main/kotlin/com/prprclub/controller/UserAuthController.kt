package com.prprclub.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserAuthController {
    @PostMapping(
            "/register",
            consumes = ["application/json"],
            produces = ["application/json"])
    fun register() {

    }

    @PostMapping(
            "/send_verify",
            consumes = ["application/json"],
            produces = ["application/json"])
    fun sendSMSVerifyCode(body: SendSMSVerifyCodeRequest) {

    }

    data class RegisterRequest(
            val username: String,
            val password: String,
            val phone: String,
            val verifyCode: String
    )

    data class SendSMSVerifyCodeRequest(
            val phone: String,
            val captcha: String
    )
}