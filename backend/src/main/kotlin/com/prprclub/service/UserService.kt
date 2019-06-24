package com.prprclub.service

import com.prprclub.model.BasicUser
import com.prprclub.model.BasicUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
interface UserService {


    fun register(username: String, password: String, phone: String) {

    }
}

@Service
class UserDetailsServiceImpl: UserDetailsService {
    @Autowired
    private lateinit var basicUserRepository: BasicUserRepository

    override fun loadUserByUsername(username: String): UserDetails {
        val user =
                basicUserRepository.findByUsername(username)
                ?: basicUserRepository.findByPhone(username)
                ?: throw UsernameNotFoundException("bad username or password!")
        return UserDetailsImpl(user)
    }
    class UserDetailsImpl(
            private val user: BasicUser
    ): UserDetails {
        override fun getUsername(): String = user.username
        override fun getPassword(): String = user.password
        override fun isEnabled(): Boolean = user.active

        override fun getAuthorities(): Collection<GrantedAuthority> = user.roles.map { SimpleGrantedAuthority(it) }

        override fun isCredentialsNonExpired(): Boolean = true
        override fun isAccountNonExpired(): Boolean = true
        override fun isAccountNonLocked(): Boolean = true
    }
}