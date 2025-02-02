package com.example.advanced.app.v5

import com.example.advanced.trace.callback.TraceCallback
import com.example.advanced.trace.callback.TraceTemplate
import com.example.advanced.trace.logtrace.LogTrace
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class OrderControllerV5(
    private val orderServiceV5: OrderServiceV5,
    private val trace: LogTrace,
    private val traceTemplate: TraceTemplate = TraceTemplate(trace = trace),
) {
    @GetMapping("/v5/request")
    fun request(@RequestParam itemId: String): String {

        return traceTemplate.execute("OrderController.request",
            object : TraceCallback<String> {
                override fun call(): String {
                    orderServiceV5.order(itemId)
                    return "ok"
                }
            })
    }
}
