package com.example.advanced.trace.strategy

import com.example.advanced.trace.strategy.code.strategy.ContextV1
import com.example.advanced.trace.strategy.code.strategy.Strategy
import org.junit.jupiter.api.Test

class ContextV1Test {

    private val log = org.slf4j.LoggerFactory.getLogger(this::class.java)

    @Test
    fun strategyV0() {
        logic1()
        logic2()
    }


    private fun logic1() {
        val startTime = System.currentTimeMillis()
        log.info("비즈니스 로직1 실행")
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info(resultTime.toString())
    }

    private fun logic2() {
        val startTime = System.currentTimeMillis()
        log.info("비즈니스 로직2 실행")
        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime
        log.info(resultTime.toString())
    }


    @Test
    fun strategyV1() {
        val context1 = com.example.advanced.trace.strategy.code.strategy.ContextV1(com.example.advanced.trace.strategy.code.strategy.StrategyLogic1())
        context1.execute()

        val context2 = com.example.advanced.trace.strategy.code.strategy.ContextV1(com.example.advanced.trace.strategy.code.strategy.StrategyLogic2())
        context2.execute()
    }


    @Test
    fun strategyV2() {
        val context1 = ContextV1(object : Strategy {
            override fun call() {
                log.info("비즈니스 로직 1")
            }
        })
        context1.execute()
        val context2 = ContextV1(object : Strategy {
            override fun call() {
                log.info("비즈니스 로직 2")
            }
        })
        context2.execute()


    }
}