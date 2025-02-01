package com.example.advanced.app.v2

import com.example.advanced.trace.TraceId
import com.example.advanced.trace.hellotrace.HelloTraceV2
import org.springframework.stereotype.Service


@Service
class OrderServiceV2(
    private val orderRepositoryV2: OrderRepositoryV2,
    private val trace: HelloTraceV2
) {

    fun order(traceId: TraceId, itemId: String) {
        val status = trace.beginSync(traceId,"OrderService.order")
        try {
            orderRepositoryV2.save(status.traceId,itemId)
            trace.end(status)
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }
}
