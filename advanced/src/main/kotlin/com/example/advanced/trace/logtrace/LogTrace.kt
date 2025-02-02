package com.example.advanced.trace.logtrace

import com.example.advanced.trace.TraceStatus

interface LogTrace {
    fun begin(message: String): TraceStatus
    fun end(traceStatus: TraceStatus)
    fun exception(traceStatus: TraceStatus, e: Exception)
}