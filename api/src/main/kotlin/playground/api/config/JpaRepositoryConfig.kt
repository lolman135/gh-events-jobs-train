package playground.api.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import playground.api.repository.impl.NaturalIdRepositoryImpl

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(
    basePackages = ["playground.api.repository"],
    repositoryBaseClass = NaturalIdRepositoryImpl::class)
class JpaRepositoryConfig {
}