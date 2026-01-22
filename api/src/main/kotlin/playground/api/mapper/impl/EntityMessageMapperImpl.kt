package playground.api.mapper.impl

import org.springframework.stereotype.Component
import playground.api.domain.Message
import playground.api.mapper.EntityMessageMapper
import playground.api.repository.entity.MessageEntity

@Component
class EntityMessageMapperImpl : EntityMessageMapper {
    override fun toDomain(entity: MessageEntity): Message {
        return Message(id = entity.businessId, header = entity.header, content = entity.content)
    }

    override fun toEntity(domain: Message): MessageEntity {
        return MessageEntity(businessId = domain.id!!, header = domain.header, content = domain.content)
    }
}