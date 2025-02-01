package com.example.advanced.app.v3

import com.example.advanced.trace.logtrace.LogTrace
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class OrderControllerV3(
    private val orderServiceV3: OrderServiceV3,
    private val trace: LogTrace
) {
    @GetMapping("/v3/request")
    fun request(@RequestParam itemId: String): String {

        val status = trace.begin("OrderController.request")
        try {
            orderServiceV3.order(itemId)
            trace.end(status)
            return "ok"
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }
}
