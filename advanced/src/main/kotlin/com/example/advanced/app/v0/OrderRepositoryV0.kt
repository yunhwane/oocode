package com.example.advanced.app.v0

import org.springframework.stereotype.Repository
import java.lang.Thread.sleep

@Repository
class OrderRepositoryV0 {

    fun save(itemId: String) {
        // 저장 로직
        if (itemId == "ex") {
            throw IllegalArgumentException("잘못된 상품 ID: $itemId")
        }

        sleep(1000)
    }

    private fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}