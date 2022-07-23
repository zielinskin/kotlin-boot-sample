package zielinskin.kotlinsample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class ServletInitializer

fun main(args: Array<String>) {
    SpringApplication.run(ServletInitializer::class.java, *args)
}

