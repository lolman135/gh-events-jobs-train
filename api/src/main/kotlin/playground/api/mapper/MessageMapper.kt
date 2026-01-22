package playground.api.mapper

import playground.api.application.command.CreateMessageCommand
import playground.api.domain.Message
import playground.api.dto.MessageDtoOutBound
import playground.api.dto.MessageInboundDto

interface MessageMapper {
    fun toCommand(dto: MessageInboundDto): CreateMessageCommand
    fun toDto(message: Message): MessageDtoOutBound
}