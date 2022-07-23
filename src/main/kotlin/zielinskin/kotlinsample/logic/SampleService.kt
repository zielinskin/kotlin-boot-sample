package zielinskin.kotlinsample.logic

import org.springframework.stereotype.Service
import zielinskin.kotlinsample.data.SampleEntity
import zielinskin.kotlinsample.data.SampleRepository
import zielinskin.kotlinsample.model.SampleDto

@Service
class SampleService(
    private val sampleRepository: SampleRepository
) {
    fun findAll(): List<SampleDto> {
        return sampleRepository.findAll()
            .map { entity ->
                mapEntity(entity)
            }
            .toList()
    }

    fun findById(id: Int): SampleDto {
        return mapEntity(sampleRepository.getOne(id))
    }

    fun findByIds(ids: List<Int>): List<SampleDto> {
        return sampleRepository.findByIdIn(ids)
            .map { entity ->
                mapEntity(entity)
            }
            .toList()
    }

    fun save(sample: SampleDto): Unit {
        sampleRepository.save(mapDto(sample))
    }

    private fun mapDto(dto: SampleDto): SampleEntity {
        return SampleEntity(dto.id, dto.name);
    }

    private fun mapEntity(entity: SampleEntity): SampleDto {
        return SampleDto(entity.id, entity.name);
    }
}