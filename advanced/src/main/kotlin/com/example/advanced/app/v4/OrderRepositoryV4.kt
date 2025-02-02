package com.example.advanced.app.v4

import com.example.advanced.trace.logtrace.LogTrace
import com.example.advanced.trace.template.AbstractTemplate
import org.springframework.stereotype.Repository

@Repository
class OrderRepositoryV4(
    private val trace: LogTrace
) {

    fun save(itemId: String) {
        // 저장 로직

        val template = object : AbstractTemplate<Unit>(trace) {
            override fun call() {
                require(itemId != "ex") { "잘못된 상품 ID: $itemId" }
                sleep(1000)
            }
        }

        template.execute("OrderRepository.save")

    }

    private fun sleep(millis: Long) {
        try {
            Thread.sleep(millis)
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }
}