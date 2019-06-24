package com.prprclub.model

import org.bson.Document
import org.springframework.core.convert.converter.Converter
import org.springframework.data.annotation.Id
import org.springframework.stereotype.Component
import javax.validation.constraints.NotNull

@org.springframework.data.mongodb.core.mapping.Document(collection = "users")
data class BasicUser(
        @Id
        val id: Long,

        @NotNull(message = "username must be not null")
        val username: String,
        @NotNull(message = "password must be not null")
        val password: String,

        @NotNull(message = "phone number must be not null")
        val phone: String,

        val roles: MutableList<String>,
        val active: Boolean
)

@Component
class BasicUserConverter: Converter<Document, BasicUser> {
    override fun convert(source: Document): BasicUser? {
        return BasicUser(
                id = source.getLong("_id") ?: throw NullPointerException("_id must be not null"),
                username = source.getString("username") ?: throw NullPointerException("username must be not null"),
                password = source.getString("password") ?: throw NullPointerException("password must be not null"),
                phone = source.getString("phone") ?: throw NullPointerException("phone must be not null"),

                roles = source.getList("roles", String::class.java) ?: throw NullPointerException("roles must be not null"),
                active = source.getBoolean("active") ?: throw NullPointerException("active must be not null")
        )
    }
}