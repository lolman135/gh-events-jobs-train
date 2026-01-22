package playground.api.web.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import playground.api.dto.HelloOutboundDto
import playground.api.application.service.HelloService

@CrossOrigin(origins = ["http://localhost:3000"])
@RestController
@RequestMapping("/api/v1/hello")
class HelloController(private val helloService: HelloService) {

    @GetMapping
    fun greetUser(): ResponseEntity<HelloOutboundDto>{
        return ResponseEntity.ok(HelloOutboundDto(helloService.greetUser()))
    }
}