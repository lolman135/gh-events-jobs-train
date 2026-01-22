package playground.api.application.service

import org.springframework.stereotype.Service
import playground.api.application.command.CreateMessageCommand
import playground.api.application.exception.NoMessageException
import playground.api.domain.Message
import playground.api.domain.MessageRepository
import java.util.UUID

@Service
class MessageServiceImpl(
    private val messageRepository: MessageRepository
) : MessageService {

    override fun saveNewMessage(command: CreateMessageCommand): Message {
        val messageBusinessId = UUID.randomUUID()
        val message = Message(messageBusinessId, command.header, command.content)
        return messageRepository.save(message)
    }

    override fun getLastMessage(): Message {
        return messageRepository.getLast() ?: throw NoMessageException()
    }

    override fun findAllMessages(): List<Message> {
        return messageRepository.findAll()
    }

    override fun deleteMessageById(id: UUID) {
        messageRepository.deleteById(id)
    }

    override fun findAllByHeader(header: String): List<Message> {
        return messageRepository.findAllByHeader(header)
    }
}