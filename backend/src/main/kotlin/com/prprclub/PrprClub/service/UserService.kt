package com.prprclub.PrprClub.service

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun loadUserDetails(username: String): UserDetails
}

class UserServiceImpl: UserService {
    override fun loadUserDetails(): UserDetails {

    }

}