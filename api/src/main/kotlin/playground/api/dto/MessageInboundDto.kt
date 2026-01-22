package playground.api.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class MessageInboundDto(
    @field:Size(min = 2, max = 40, message = "Must be at least 2 symbols, but not bigger than 255")
    val header: String,
    @field:NotBlank(message = "Content mustn't be empty")
    val content: String
)