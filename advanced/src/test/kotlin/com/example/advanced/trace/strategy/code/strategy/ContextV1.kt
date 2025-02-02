package com.example.advanced.trace.strategy.code.strategy

/**
 * 필드에 전략을 보관하는 방식
 */
class ContextV1 (
    private val strategy: Strategy
){

    private val log = org.slf4j.LoggerFactory.getLogger(this::class.java)

    fun execute() {
        val startTime = System.currentTimeMillis()
        strategy.call()
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info(resultTime.toString())
    }
}