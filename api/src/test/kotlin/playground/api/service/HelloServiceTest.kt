package playground.api.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import playground.api.application.service.HelloService
import kotlin.test.Test
import kotlin.test.assertEquals

@SpringBootTest(classes = [HelloService::class])
class HelloServiceTest {

    @Autowired
    private lateinit var helloService: HelloService

    @Test
    fun shouldReturnHelloWorldString(){
        val greetUser = helloService.greetUser()
        assertEquals("Hello World", greetUser)
    }
}