package com.example.advanced.trace.callback

import com.example.advanced.trace.logtrace.LogTrace
import org.springframework.stereotype.Component

@Component
class TraceTemplate (
    private val trace: LogTrace
){
    private val log = org.slf4j.LoggerFactory.getLogger(this::class.java)

    fun <T> execute(message: String, callback: TraceCallback<T>): T {
        val status = trace.begin(message)
        try {
            val result = callback.call()
            trace.end(status)
            return result
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }
}