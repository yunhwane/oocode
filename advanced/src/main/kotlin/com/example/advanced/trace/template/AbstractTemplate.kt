package com.example.advanced.trace.template

import com.example.advanced.trace.logtrace.LogTrace

abstract class AbstractTemplate<T>(
    private val trace: LogTrace,
) {
    private val log = org.slf4j.LoggerFactory.getLogger(this::class.java)

    abstract fun call(): T

    fun execute(message: String): T {
        val status = trace.begin(message)

        try {
            val result: T = call()
            trace.end(status)
            return result
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }


}