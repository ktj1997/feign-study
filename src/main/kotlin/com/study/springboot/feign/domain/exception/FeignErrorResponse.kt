package com.study.springboot.feign.domain.exception

class FeignErrorResponse(val status: Int,
                         val error: ErrorResponse) {
}