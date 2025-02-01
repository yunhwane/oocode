package com.example.advanced.trace.hellotrace

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HelloTraceV2Test {

    @Test
    fun begin_end() {
        val helloTrace = HelloTraceV2()
        val status1 = helloTrace.begin("hello1")
        val status2 = helloTrace.beginSync(status1.traceId, "hello2")
        helloTrace.end(status2)
        helloTrace.end(status1)
    }

    @Test
    fun begin_exception() {
        val helloTrace = HelloTraceV2()
        val status1 = helloTrace.begin("hello1")
        val status2 = helloTrace.beginSync(status1.traceId, "hello2")
        helloTrace.exception(status2, IllegalStateException("error"))
        helloTrace.exception(status1, IllegalStateException("error"))
    }

}