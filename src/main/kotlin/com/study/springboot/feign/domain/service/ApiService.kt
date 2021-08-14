package com.study.springboot.feign.domain.service

import com.study.springboot.feign.domain.client.SampleFeignClient
import com.study.springboot.feign.domain.model.SampleApiDto
import org.springframework.stereotype.Service

@Service
class ApiService(
        val sampleFeignClient: SampleFeignClient
) {

    fun paramService(title: String, text: String): SampleApiDto {
        return sampleFeignClient.sampleApiRequestParam(title, text)
    }

    fun bodyService(dto: SampleApiDto): SampleApiDto {
        return sampleFeignClient.sampleApiRequestBody(dto)
    }

    fun pathVariableService(id: Long): SampleApiDto {
        return sampleFeignClient.sampleApiPathVariable(id, "headerValue")
    }


}