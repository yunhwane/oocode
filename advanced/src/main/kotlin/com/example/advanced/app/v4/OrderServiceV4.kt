package com.example.advanced.app.v4


import com.example.advanced.trace.logtrace.LogTrace
import com.example.advanced.trace.template.AbstractTemplate
import org.springframework.stereotype.Service


@Service
class OrderServiceV4(
    private val orderRepositoryV4: OrderRepositoryV4,
    private val trace: LogTrace
) {

    fun order(itemId: String) {

        val template = object : AbstractTemplate<Unit>(trace) {
            override fun call() {
                orderRepositoryV4.save(itemId)
            }
        }

        template.execute("OrderService.order")
    }
}
