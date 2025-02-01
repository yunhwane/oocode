package com.example.advanced.trace.hellotrace

import com.example.advanced.trace.TraceId
import com.example.advanced.trace.TraceStatus
import org.springframework.stereotype.Component


@Component
class HelloTraceV1 {

    fun begin(message: String): TraceStatus {
        val traceId = TraceId()
        val startTimeMs = System.currentTimeMillis()
        println("[${traceId.id}] ${addSpace(START_PREFIX, traceId.level)}$message")
        return TraceStatus(traceId, startTimeMs, message)
    }

    fun end(status: TraceStatus) {
        complete(status, null)
    }

    fun exception(status: TraceStatus, e: Exception?) {
        complete(status, e)
    }

    fun complete(status: TraceStatus, e: Exception?) {
        val stopTimeMs = System.currentTimeMillis()
        val resultTimeMs = stopTimeMs - status.startTimeMs
        val traceId = status.traceId

        if (e == null) {
            println("[${traceId.id}] ${addSpace(END_PREFIX, traceId.level)}${status.message} time=${resultTimeMs}ms")
        } else {
            println("[${traceId.id}] ${addSpace(EXCEPTION_PREFIX, traceId.level)}${status.message} time=${resultTimeMs}ms ex=${e}")
        }
    }


    fun addSpace(prefix: String, level: Int): String {
        return buildString {
            repeat(level) { i ->
                append(if (i == level - 1) "|$prefix" else "|   ")
            }
        }
    }

    companion object {
        const val START_PREFIX = "-->"
        const val END_PREFIX = "<--"
        const val EXCEPTION_PREFIX = "<X--"
    }
}