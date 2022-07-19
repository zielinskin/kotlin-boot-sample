package zielinskin.kotlinsample.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import zielinskin.kotlinsample.data.SampleEntity
import zielinskin.kotlinsample.logic.SampleService

@RestController
@RequestMapping("/samples")
class SampleController(
    private val sampleService: SampleService
) {
    @GetMapping
    fun findAll() : List<SampleEntity> {
        return sampleService.findAll()
    }

    @GetMapping("/{id}")
    fun findById(id: Integer) : SampleEntity {
        return sampleService.findById(id)
    }

    @PostMapping
    fun findByIds(ids : List<Integer>) : List<SampleEntity> {
        return sampleService.findByIds(ids)
    }

    @PutMapping
    fun save(sample : SampleEntity) : Unit {
        sampleService.save(sample)
    }
}