package com.study.springboot.feign.domain.client

import com.study.springboot.feign.domain.model.SampleApiDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.*

@FeignClient(name = "SampleMsaServer", url = "\${sample.api.url}")
interface SampleFeignClient {

    @GetMapping("/path-variable/{id}")
    fun sampleApiPathVariable(@PathVariable id: Long): SampleApiDto

    @GetMapping("/param")
    fun sampleApiRequestParam(
            @RequestParam title: String,
            @RequestParam text: String
    ): SampleApiDto

    @PostMapping("/body")
    fun sampleApiRequestBody(
            @RequestBody sampleApiDto: SampleApiDto
    ): SampleApiDto
}