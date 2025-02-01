package com.example.advanced.app.v3


import com.example.advanced.trace.logtrace.LogTrace
import org.springframework.stereotype.Service


@Service
class OrderServiceV3(
    private val orderRepositoryV3: OrderRepositoryV3,
    private val trace: LogTrace
) {

    fun order(itemId: String) {
        val status = trace.begin("OrderService.order")
        try {
            orderRepositoryV3.save(itemId)
            trace.end(status)
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }
}
