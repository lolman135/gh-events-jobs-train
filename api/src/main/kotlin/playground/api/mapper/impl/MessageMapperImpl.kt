package playground.api.mapper.impl

import org.springframework.stereotype.Component
import playground.api.application.command.CreateMessageCommand
import playground.api.domain.Message
import playground.api.dto.MessageDtoOutBound
import playground.api.dto.MessageInboundDto
import playground.api.mapper.MessageMapper

@Component
class MessageMapperImpl : MessageMapper {
    override fun toCommand(dto: MessageInboundDto) = CreateMessageCommand(header = dto.header, content = dto.content)

    override fun toDto(message: Message): MessageDtoOutBound {
        return MessageDtoOutBound(id = message.id!!, header = message.header, content = message.content)
    }
}