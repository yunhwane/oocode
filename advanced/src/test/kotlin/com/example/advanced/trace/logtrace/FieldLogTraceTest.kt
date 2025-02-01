package com.example.advanced.trace.logtrace

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FieldLogTraceTest {

    private val trace = FieldLogTrace()

    @Test
    fun begin_end_level2() {
        val status1 = trace.begin("1st trace")
        val status2 = trace.begin("2nd trace")
        trace.end(status2)
        trace.end(status1)
    }

    @Test
    fun begin_exception_level2() {
        val status1 = trace.begin("1st trace")
        val status2 = trace.begin("2nd trace")
        trace.exception(status2, IllegalStateException("Illegal state"))
        trace.exception(status1, IllegalStateException("Illegal state"))
    }

}