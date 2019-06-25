package com.prprclub.security

import com.prprclub.service.UserDetailsServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher


@Configuration
@EnableWebSecurity
class SecurityManager: WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var userDetailsService: UserDetailsServiceImpl
    @Autowired
    lateinit var authResultHandler: AuthenticationResultHandler

    override fun configure(http: HttpSecurity) {
        http
                .csrf().disable()
                .authorizeRequests()
                    .anyRequest().permitAll()
                .and()
                .addFilterBefore(
                        authenticationFilter(),
                        UsernamePasswordAuthenticationFilter::class.java)
                /*.formLogin()
                    .loginProcessingUrl("/login")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .successHandler(authResultHandler)
                    .failureHandler(authResultHandler)*/
    }

    override fun userDetailsService(): UserDetailsService = userDetailsService

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun authenticationFilter(): JSONLoginCaptchaFilter {
        return JSONLoginCaptchaFilter().apply {
            setAuthenticationSuccessHandler(authResultHandler)
            setAuthenticationFailureHandler(authResultHandler)
            setRequiresAuthenticationRequestMatcher(AntPathRequestMatcher("/login", "POST"))
            setAuthenticationManager(authenticationManagerBean())
        }
    }
}