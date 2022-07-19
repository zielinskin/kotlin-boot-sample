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

    fun findById(id: Integer) : SampleEntity {
        return sampleRepository.getReferenceById(id)
    }

    fun findByIds(ids : List<Integer>) : List<SampleEntity> {
        return sampleRepository.findByIdIn(ids)
    }

    fun save(sample : SampleEntity) : Unit {
        sampleRepository.save(sample)
    }
}