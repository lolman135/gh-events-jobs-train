package playground.api.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import playground.api.repository.entity.MessageEntity
import java.util.Optional
import java.util.UUID

@Repository
interface MessageJpaRepository : NaturalIdRepository<MessageEntity, UUID> {

    @Query("SELECT e FROM MessageEntity e ORDER BY e.id DESC LIMIT 1")
    fun findLast(): Optional<MessageEntity>
}