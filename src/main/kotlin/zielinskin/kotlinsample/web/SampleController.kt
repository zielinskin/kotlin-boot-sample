package zielinskin.kotlinsample.web

import org.springframework.web.bind.annotation.*
import zielinskin.kotlinsample.data.SampleEntity
import zielinskin.kotlinsample.logic.SampleService
import zielinskin.kotlinsample.model.SampleDto

@RestController
@RequestMapping("/samples")
class SampleController(
    private val sampleService: SampleService
) {
    @GetMapping
    fun findAll() : List<SampleDto> {
        return sampleService.findAll()
    }

    @GetMapping("/{id}")
    fun findById(id: Int) : SampleDto {
        return sampleService.findById(id)
    }

    @PostMapping("/findByIds")
    fun findByIds(@RequestBody ids : List<Int>) : List<SampleDto> {
        return sampleService.findByIds(ids)
    }

    @PostMapping
    fun save(sample : SampleDto) : Unit {
        sampleService.save(sample)
    }
}