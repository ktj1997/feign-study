package com.study.springboot.feign.domain.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.study.springboot.feign.domain.exception.FeignErrorResponse
import com.study.springboot.feign.domain.exception.InternalRequestException
import feign.Response
import feign.codec.ErrorDecoder
import java.nio.charset.Charset


class FeignErrorDecoder(
        private val objectMapper: ObjectMapper
) : ErrorDecoder {
    override fun decode(methodKey: String?, response: Response?): InternalRequestException {
        val errorResponse = objectMapper.readValue(response!!.body().asReader(Charset.defaultCharset()), FeignErrorResponse::class.java)
        throw InternalRequestException(errorResponse.status, errorResponse.error)
    }
}