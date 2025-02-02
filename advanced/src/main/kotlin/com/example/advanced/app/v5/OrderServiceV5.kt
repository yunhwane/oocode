package com.example.advanced.app.v5


import com.example.advanced.trace.callback.TraceCallback
import com.example.advanced.trace.callback.TraceTemplate
import com.example.advanced.trace.logtrace.LogTrace
import com.example.advanced.trace.template.AbstractTemplate
import org.springframework.stereotype.Service


@Service
class OrderServiceV5(
    private val orderRepositoryV5: OrderRepositoryV5,
    private val trace: LogTrace,
    private val template : TraceTemplate = TraceTemplate(trace)
) {

    fun order(itemId: String) {
        template.execute("OrderService.order",
            object : TraceCallback<Unit> {
                override fun call() {
                    orderRepositoryV5.save(itemId)
                }
            }
        )
    }
}
