package zielinskin.kotlinsample.logic

import org.springframework.stereotype.Service
import zielinskin.kotlinsample.data.SampleEntity
import zielinskin.kotlinsample.data.SampleRepository

@Service
class SampleService(
    private val sampleRepository: SampleRepository
) {
    fun findAll() : List<SampleEntity> {
        return sampleRepository.findAll()
    }

    fun findById(id: Int) : SampleEntity {
        return sampleRepository.getOne(id)
    }

    fun findByIds(ids : List<Int>) : List<SampleEntity> {
        return sampleRepository.findByIdIn(ids)
    }

    fun save(sample : SampleEntity) : Unit {
        sampleRepository.save(sample)
    }
}