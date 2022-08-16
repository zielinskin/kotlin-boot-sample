package zielinskin.kotlinsample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan("zielinskin.kotlinsample.*")
@EnableJpaRepositories("zielinskin.kotlinsample.*")
class ServletInitializer

fun main(args: Array<String>) {
    SpringApplication.run(ServletInitializer::class.java, *args)
}

