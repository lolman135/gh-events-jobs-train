package playground.api.domain

import java.util.UUID

interface MessageRepository {
    fun findAll(): List<Message>
    fun findById(id: UUID): Message?
    fun getLast(): Message?
    fun save(message: Message): Message
    fun deleteById(id: UUID)
    fun existMessageById(id: UUID): Boolean
    fun findAllByHeader(header: String): List<Message>
}