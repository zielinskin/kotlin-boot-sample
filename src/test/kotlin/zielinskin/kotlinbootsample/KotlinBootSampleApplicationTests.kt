package zielinskin.kotlinbootsample

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import zielinskin.kotlinsample.KotlinBootSampleApplication
import zielinskin.kotlinsample.data.SampleEntity
import zielinskin.kotlinsample.data.SampleRepository
import javax.transaction.Transactional

@SpringBootTest(classes = [KotlinBootSampleApplication::class])
@Transactional
class KotlinBootSampleApplicationTests  {
	@Autowired
	private lateinit var sampleRepository: SampleRepository
	@Test
	fun contextLoads() {
		val sample = sampleRepository.save(SampleEntity(name="test1"))
		assertThat(sampleRepository.findById(sample.id!!)).isNotNull
	}
}
