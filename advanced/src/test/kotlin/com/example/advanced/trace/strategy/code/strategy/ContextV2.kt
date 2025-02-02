package com.example.advanced.trace.strategy.code.strategy

/**
 * 전략을 파라미터로 받는 방식
 */
class ContextV2 {

    private val log = org.slf4j.LoggerFactory.getLogger(this::class.java)

    fun execute(strategy: Strategy) {
        val startTime = System.currentTimeMillis()
        strategy.call()
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info(resultTime.toString())
    }
}