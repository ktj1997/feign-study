package com.study.springboot.feign.domain.exception

import java.util.*

class ErrorResponse(val message: String, val code: String,val timeStamp: Date) {
}