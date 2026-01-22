package playground.api.repository.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import org.hibernate.annotations.NaturalId
import java.util.UUID

@Entity
@Table(name = "messages")
class MessageEntity(

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_id_seq")
    @get:SequenceGenerator(name = "message_id_seq", sequenceName = "message_id_seq", allocationSize = 50)
    var id: Long? = null,

    @get:Column(name = "business_id")
    @get:NaturalId
    var businessId: UUID,

    var header: String,
    var content: String
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MessageEntity

        return businessId == other.businessId
    }

    override fun hashCode(): Int {
        return businessId.hashCode()
    }
}