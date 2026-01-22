package playground.api.repository.domainImpl

import org.springframework.stereotype.Repository
import playground.api.domain.Message
import playground.api.domain.MessageRepository
import playground.api.mapper.EntityMessageMapper
import playground.api.repository.MessageJpaRepository
import java.util.UUID

@Repository
class MessageRepositoryImpl(
    private val jpaRepository: MessageJpaRepository,
    private val messageMapper: EntityMessageMapper
) : MessageRepository {

    override fun findAll(): List<Message> {
        return jpaRepository.findAll().map { messageMapper.toDomain(it) }
    }

    override fun findById(id: UUID): Message? {
        val optionalMessageEntity = jpaRepository.findByNaturalId(id)
        return optionalMessageEntity.map { messageMapper.toDomain(it) }.orElse(null)
    }

    override fun getLast(): Message? {
        val optionalMessageEntity = jpaRepository.findLast()
        return optionalMessageEntity.map { messageMapper.toDomain(it) }.orElse(null)
    }

    override fun save(message: Message): Message {
        val entity = jpaRepository.findByNaturalId(message.id!!).orElse(null)

        return if(entity == null){
            val entityToSave = messageMapper.toEntity(message)
            messageMapper.toDomain(jpaRepository.save(entityToSave))
        } else{
            entity.apply {
                header = message.header
                content = message.content
            }
            messageMapper.toDomain(entity)
        }
    }

    override fun deleteById(id: UUID) {
        jpaRepository.deleteByNaturalId(id)
    }

    override fun existMessageById(id: UUID) = jpaRepository.existsByNaturalId(id)

    override fun findAllByHeader(header: String): List<Message> {
        return jpaRepository.findAll().filter { it.header == header }.map { messageMapper.toDomain(it) }
    }
}