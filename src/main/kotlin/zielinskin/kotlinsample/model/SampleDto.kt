package zielinskin.kotlinsample.model

import com.fasterxml.jackson.annotation.JsonProperty

data class SampleDto(
    @get:JsonProperty("id") val id: Int? = null,
    @get:JsonProperty("name") val name: String
)