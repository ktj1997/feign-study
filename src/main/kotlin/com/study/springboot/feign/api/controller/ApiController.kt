package com.study.springboot.feign.api.controller

import com.study.springboot.feign.api.request.SampleApiRequest
import com.study.springboot.feign.api.response.SampleResponse
import com.study.springboot.feign.domain.service.ApiService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ApiController(
        private val apiService: ApiService
) {

    @GetMapping("/{id}")
    fun pathVariableExample(@PathVariable id: Long): SampleResponse {
        return SampleResponse(apiService.pathVariableService(id))
    }

    @GetMapping
    fun paramService(
            @RequestParam title: String,
            @RequestParam text: String
    ): SampleResponse {
        return SampleResponse(apiService.paramService(title, text))
    }

    @PostMapping
    fun bodyService(
            @RequestBody req: SampleApiRequest
    ): SampleResponse {
        return SampleResponse(apiService.bodyService(req.request))
    }
}