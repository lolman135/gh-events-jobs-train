package playground.api.domain

import java.util.UUID

data class Message(
    val id: UUID?,
    val header: String,
    val content: String
)