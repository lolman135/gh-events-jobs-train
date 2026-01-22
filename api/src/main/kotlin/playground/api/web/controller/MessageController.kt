package playground.api.web.controller

import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import playground.api.application.service.MessageService
import playground.api.dto.MessageDtoOutBound
import playground.api.dto.MessageInboundDto
import playground.api.mapper.MessageMapper
import java.net.URI
import java.util.UUID

@RestController
@RequestMapping("/api/v1/messages")
@Validated
class MessageController(
    private val messageService: MessageService,
    private val messageMapper: MessageMapper,
) {

    @PostMapping
    fun save(@RequestBody @Valid inboundDto: MessageInboundDto): ResponseEntity<MessageDtoOutBound> {
        val createMessageCommand = messageMapper.toCommand(inboundDto)
        val dtoOutBound = messageMapper.toDto(messageService.saveNewMessage(createMessageCommand))
        val location = URI.create("/api/v1/messages")
        return ResponseEntity.created(location).body(dtoOutBound)
    }

    @GetMapping
    fun getAll(@RequestParam header: String?): ResponseEntity<List<MessageDtoOutBound>>{
        return if (header == null){
            ResponseEntity.ok(messageService.findAllMessages().map { messageMapper.toDto(it) })
        } else {
            ResponseEntity.ok(messageService.findAllByHeader(header).map { messageMapper.toDto(it) })
        }
    }

    @GetMapping("/last")
    fun getLast(): ResponseEntity<MessageDtoOutBound?> =
        ResponseEntity.ok(messageMapper.toDto(messageService.getLastMessage()))

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID): ResponseEntity<Void> {
        messageService.deleteMessageById(id)
        return ResponseEntity.noContent().build()
    }
}