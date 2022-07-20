package zielinskin.kotlinsample.data

import org.springframework.data.jpa.repository.JpaRepository

interface SampleRepository : JpaRepository<SampleEntity, Int> {
    fun findByIdIn(ids: List<Int>) : List<SampleEntity>
}