package com.example.advanced.app.v4

import com.example.advanced.trace.logtrace.LogTrace
import com.example.advanced.trace.template.AbstractTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class OrderControllerV4(
    private val orderServiceV4: OrderServiceV4,
    private val trace: LogTrace
) {
    @GetMapping("/v4/request")
    fun request(@RequestParam itemId: String): String {


        val template = object : AbstractTemplate<String>(trace) {
            override fun call(): String {
                orderServiceV4.order(itemId)
                return "ok"
            }
        }

        return template.execute("OrderController.request")
    }
}
