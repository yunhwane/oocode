package com.example.advanced.trace.logtrace

import com.example.advanced.trace.TraceId
import com.example.advanced.trace.TraceStatus

class ThreadLocalLogTrace : LogTrace {

    private val log = org.slf4j.LoggerFactory.getLogger(ThreadLocalLogTrace::class.java)
    private var traceIdHolder: ThreadLocal<TraceId> = ThreadLocal()

    override fun begin(message: String): TraceStatus {
        syncTraceId()
        val traceId = traceIdHolder.get()
        val startTimeMs = System.currentTimeMillis()
        log.info("[{}] {}{}", traceId.id, addSpace(START_PREFIX, traceId.level), message)
        return TraceStatus(traceId, startTimeMs, message)
    }

    override fun end(traceStatus: TraceStatus) {
        complete(traceStatus, null)
    }

    override fun exception(traceStatus: TraceStatus, e: Exception) {
        complete(traceStatus, e)
    }

    private fun complete(status: TraceStatus, e: Exception?) {
        val stopTimeMs = System.currentTimeMillis()
        val resultTimeMs = stopTimeMs - status.startTimeMs
        val traceId = status.traceId

        if (e == null) {
            log.info("[{}] {}{} time={}ms", traceId.id, addSpace(COMPLETE_PREFIX, traceId.level), status.message, resultTimeMs)
        } else {
            log.info("[{}] {}{} time={}ms ex={}", traceId.id, addSpace(EX_PREFIX, traceId.level), status.message, resultTimeMs, e.toString())
        }
        releaseTraceId()
    }

    private fun syncTraceId() {
        traceIdHolder.set(if (traceIdHolder.get() == null) {
            TraceId()
        } else {
            traceIdHolder.get()!!.createNextId()
        })
    }

    private fun releaseTraceId() {
        if (traceIdHolder.get().isFirstLevel()) {
            traceIdHolder.remove() // destroy
        } else {
            traceIdHolder.set(traceIdHolder.get().createPreviousId())
        }
    }

    private fun addSpace(prefix: String, level: Int): String {
        return buildString {
            for (i in 0 until level) {
                append(if (i == level - 1) "|$prefix" else "|   ")
            }
        }
    }

    companion object {
        const val START_PREFIX = "-->"
        const val COMPLETE_PREFIX = "<--"
        const val EX_PREFIX = "<X--"
    }

}