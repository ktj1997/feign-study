package com.study.springboot.feign.domain.service

import com.study.springboot.feign.domain.client.SampleFeignClient
import com.study.springboot.feign.domain.model.SampleApiDto
import io.github.resilience4j.bulkhead.annotation.Bulkhead
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service

@Service
class ApiService(
        val sampleFeignClient: SampleFeignClient
) {
    companion object {
        const val RESILIENCE4J = "test-circuit"
    }

    @Bulkhead(name = RESILIENCE4J)
    @CircuitBreaker(name = RESILIENCE4J, fallbackMethod = "fallbackMethod")
    fun paramService(title: String, text: String): SampleApiDto {
        return sampleFeignClient.sampleApiRequestParam(title, text)
    }

    @Bulkhead(name = RESILIENCE4J)
    @CircuitBreaker(name = RESILIENCE4J, fallbackMethod = "fallbackMethod")
    fun bodyService(dto: SampleApiDto): SampleApiDto {
        return sampleFeignClient.sampleApiRequestBody(dto)
    }

    @Bulkhead(name = RESILIENCE4J)
    @CircuitBreaker(name = RESILIENCE4J, fallbackMethod = "fallbackMethod")
    fun pathVariableService(id: Long): SampleApiDto {
        return sampleFeignClient.sampleApiPathVariable(id, "headerValue")
    }

    /**
     * fallback Method의 경우 리턴값 일치, 에러를 파라미터로 받아야함.
     * 보통 빈값 넘겨줌
     */
    fun fallbackMethod(e: Exception): SampleApiDto {
        return SampleApiDto()
    }

}