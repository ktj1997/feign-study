package com.study.springboot.feign.domain.model

class SampleApiDto(val title: String?, val text: String?) {
    constructor():this(null,null)
}