package com.study.springboot.feign.domain.config

import com.fasterxml.jackson.databind.ObjectMapper
import feign.RequestInterceptor
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfiguration(
        @Value("\${server.app.token}")
        private val serverToken: String,
        private val objectMapper: ObjectMapper
) {
    @Bean
    fun requestInterceptor(): RequestInterceptor? {
        return RequestInterceptor { requestTemplate -> requestTemplate.header("Authorization", "Bearer $serverToken") }
    }

    @Bean
    fun errorDecoder(): FeignErrorDecoder {
        return FeignErrorDecoder(objectMapper)
    }
}