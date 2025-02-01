package com.example.advanced.app.v1

import com.example.advanced.trace.hellotrace.HelloTraceV1
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryV1(
    private val trace: HelloTraceV1
) {

    fun save(itemId: String) {
        // 저장 로직
        val status = trace.begin("OrderRepository.save")
        try {
            if (itemId == "ex") {
                throw IllegalArgumentException("잘못된 상품 ID: $itemId")
            }

            sleep(1000)
            trace.end(status)
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }

    private fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}