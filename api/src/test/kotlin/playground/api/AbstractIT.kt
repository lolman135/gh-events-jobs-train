package playground.api

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import kotlin.apply

@SpringBootTest
@AutoConfigureMockMvc
abstract class AbstractIT{

    companion object{
        @JvmStatic
        val postgres = PostgreSQLContainer("postgres:18-alpine").apply {
            withDatabaseName("testdb")
            withUsername("test")
            withPassword("test")
            start()
        }

        @JvmStatic
        @DynamicPropertySource
        fun registerProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url") {postgres.jdbcUrl}
            registry.add("spring.datasource.username") {postgres.username}
            registry.add("spring.datasource.password") {postgres.password}
            registry.add("spring.jpa.hibernate.ddl-auto") { "validate" }
            registry.add("spring.jpa.hibernate.ddl-auto") { "none" }
        }
    }

    abstract fun getInfoAboutLoadingDocker()
}