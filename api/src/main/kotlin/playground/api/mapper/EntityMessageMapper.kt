package playground.api.mapper

import playground.api.domain.Message
import playground.api.repository.entity.MessageEntity

interface EntityMessageMapper {

    fun toDomain(entity: MessageEntity): Message
    fun toEntity(domain: Message): MessageEntity
}