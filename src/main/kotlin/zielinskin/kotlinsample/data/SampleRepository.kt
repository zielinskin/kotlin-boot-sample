package zielinskin.kotlinsample.data

import org.springframework.data.jpa.repository.JpaRepository

interface SampleRepository : JpaRepository<SampleEntity, Integer> {
    fun findByIdIn(ids: List<Integer>) : List<SampleEntity>
}