package playground.api.application.exception

import java.util.UUID

class MessageNotFoundByIdException(val id: UUID) : Exception(){
    override val message: String
        get() = "Message with id=$id not found"
}