package com.example.advanced.app.v5

import com.example.advanced.trace.callback.TraceCallback
import com.example.advanced.trace.callback.TraceTemplate
import com.example.advanced.trace.logtrace.LogTrace
import com.example.advanced.trace.template.AbstractTemplate
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryV5(
    private val trace: LogTrace,
    private val template: TraceTemplate = TraceTemplate(trace)
) {

    fun save(itemId: String) {
        template.execute("OrderRepository.save", object : TraceCallback<Unit> {
            override fun call() {
                require(itemId != "ex") { "잘못된 상품 ID: $itemId" }
                sleep(1000)
            }
        })
    }

    private fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}