package com.prprclub.model

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface BasicUserRepository: MongoRepository<BasicUser, Long> {
    fun findByUsername(username: String): BasicUser?
    fun findByPhone(phone: String): BasicUser?
}