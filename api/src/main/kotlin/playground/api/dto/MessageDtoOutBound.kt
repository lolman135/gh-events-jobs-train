package playground.api.dto

import java.util.UUID

data class MessageDtoOutBound(val id: UUID, val header: String, val content: String)