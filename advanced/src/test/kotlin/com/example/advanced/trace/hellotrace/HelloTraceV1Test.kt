package com.example.advanced.trace.hellotrace

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HelloTraceV1Test {

    @Test
    fun begin_end() {
        val helloTrace = HelloTraceV1()
        val status = helloTrace.begin("hello")
        helloTrace.end(status)
    }

    @Test
    fun begin_exception() {
        val helloTrace = HelloTraceV1()
        val status = helloTrace.begin("hello")
        helloTrace.exception(status, IllegalStateException("error"))
    }


}