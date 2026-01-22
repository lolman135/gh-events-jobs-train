package playground.api.application.service

import playground.api.application.command.CreateMessageCommand
import playground.api.domain.Message
import java.util.UUID

interface MessageService {
    fun saveNewMessage(command: CreateMessageCommand): Message
    fun getLastMessage(): Message
    fun findAllMessages(): List<Message>
    fun deleteMessageById(id: UUID)
    fun findAllByHeader(header: String): List<Message>
}
