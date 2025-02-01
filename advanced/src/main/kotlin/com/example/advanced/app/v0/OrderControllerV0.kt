package com.example.advanced.app.v0

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class OrderControllerV0(
    private val orderServiceV0: OrderServiceV0
) {
    @GetMapping("/v0/request")
    fun request(@RequestParam itemId: String): String {
        orderServiceV0.order(itemId)
        return "ok"
    }
}
