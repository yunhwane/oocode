package com.example.advanced.trace

data class TraceStatus (
    val traceId: TraceId,
    val startTimeMs: Long = System.currentTimeMillis(),
    val message: String,
){
}