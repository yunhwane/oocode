package com.example.advanced.app.v0

import org.springframework.stereotype.Service


@Service
class OrderServiceV0(
    private val orderRepositoryV0: OrderRepositoryV0
) {


    fun order(itemId: String) {
        orderRepositoryV0.save(itemId)
    }
}
