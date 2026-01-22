package playground.api.application.exception

class NoMessageException : Exception() {
    override val message: String
        get() = "No messages on server"
}