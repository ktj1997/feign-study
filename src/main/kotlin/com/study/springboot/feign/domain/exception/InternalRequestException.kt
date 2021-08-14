package com.study.springboot.feign.domain.exception

class InternalRequestException(
        val status: Int,
        override val message: String,
        val code: String
) : RuntimeException() {
    constructor(status: Int, error: ErrorResponse) : this(status, error.message, error.code)
    constructor() : this(400, "connection-timeout", "SYSTEM-001")
}