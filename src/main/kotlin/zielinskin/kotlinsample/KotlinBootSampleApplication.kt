package zielinskin.kotlinsample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import zielinskin.kotlinsample.data.SampleEntity

@SpringBootApplication
@EntityScan(basePackageClasses = [SampleEntity::class])
@EnableJpaRepositories
class KotlinBootSampleApplication

fun main(args: Array<String>) {
	runApplication<KotlinBootSampleApplication>(*args)
}
